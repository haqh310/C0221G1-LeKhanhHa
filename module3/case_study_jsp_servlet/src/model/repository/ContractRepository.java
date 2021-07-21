package model.repository;

import model.bean.contract.AttachService;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    BaseRepository repository = new BaseRepository();
    private final String SELECT_ALL_CONTRACT = "select * from contract";
    private final String SELECT_ALL_CONTRACT_DETAIL = "select * from contract_detail";
    private final String SELECT_ALL_ATTACH_SERVICE = "select * from attach_service";
    private final String INSERT_CONTRACT = "insert into contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id) " +
            "values(?,?,?,?,?,?,?)";
    private final String INSERT_CONTRACT_DETAIL = "insert into contract_detail(contract_id, attach_service_id, quantity) " +
            "values(?,?,?)";
    private final String SELECT_CUSTOMER_CONTRACT = "call select_customer_contract()";
    private final String SELECT_ATTACH_SERVICE = "call select_attach_service(?)";
    private final String UPDATE_TOTAL_MONEY = "call update_total_money(?)";

    public List<Contract> findAllContract() {
        List<Contract> contracts = new ArrayList<>();
        try {
            Connection connection = repository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CONTRACT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int contract_id = resultSet.getInt("contract_id");
                Date contract_start_date = resultSet.getDate("contract_start_date");
                Date contract_end_date = resultSet.getDate("contract_end_date");
                Double contract_deposit = resultSet.getDouble("contract_deposit");
                Double contract_total_money = resultSet.getDouble("contract_total_money");
                int employee_id = resultSet.getInt("employee_id");
                int customer_id = resultSet.getInt("customer_id");
                int service_id = resultSet.getInt("service_id");
                contracts.add(new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }

    public List<ContractDetail> findAllContractDetail() {
        List<ContractDetail> contractDetails = new ArrayList<>();
        try {
            Connection connection = repository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int contract_detail_id = resultSet.getInt("contract_detail_id");
                int contract_id = resultSet.getInt("contract_id");
                int attach_service_id = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                contractDetails.add(new ContractDetail(contract_detail_id, contract_id, attach_service_id, quantity));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetails;
    }

    public List<AttachService> findAllAttachService() {
        List<AttachService> attachServices = new ArrayList<>();
        try {
            Connection connection = repository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ATTACH_SERVICE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int attach_service_id = resultSet.getInt("attach_service_id");
                String attach_service_name = resultSet.getString("attach_service_name");
                double attach_service_cost = resultSet.getDouble("attach_service_cost");
                int attach_service_unit = resultSet.getInt("attach_service_unit");
                String attach_service_status = resultSet.getString("attach_service_status");
                attachServices.add(new AttachService(attach_service_id, attach_service_name, attach_service_cost, attach_service_unit, attach_service_status));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachServices;
    }

    public List<String[]> findCustomerContract() {
        List<String[]> list = new ArrayList<>();
        Connection connection = repository.connectDataBase();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall(SELECT_CUSTOMER_CONTRACT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String customer_id = resultSet.getString("customer_id");
                String customer_name = resultSet.getString("customer_name");
                String employee_name = resultSet.getString("employee_name");
                String service_name = resultSet.getString("service_name");
                String attach_service_name = resultSet.getString("attach_service_name");
                String contract_total_money = resultSet.getString("contract_total_money");
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                String[] s = {customer_id, customer_name, employee_name, service_name, attach_service_name, contract_total_money, contract_start_date, contract_end_date};
                list.add(s);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public void insertContract(Contract contract) {
        try {
            Connection connection = repository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement(INSERT_CONTRACT);
            statement.setDate(1, contract.getContract_start_date());
            statement.setDate(2, contract.getContract_end_date());
            statement.setDouble(3, contract.getContract_deposit());
            statement.setDouble(4, contract.getContract_total_money());
            statement.setInt(5, contract.getEmployee_id());
            statement.setInt(6, contract.getCustomer_id());
            statement.setInt(7, contract.getService_id());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertContractDetail(ContractDetail contractDetail) {
        Connection connection = repository.connectDataBase();
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL);
            preparedStatement.setInt(1, contractDetail.getContract_id());
            preparedStatement.setInt(2, contractDetail.getAttach_service_id());
            preparedStatement.setInt(3, contractDetail.getQuantity());
            int rowUpdate = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (rowUpdate == 1) {
                CallableStatement callableStatement = connection.prepareCall(UPDATE_TOTAL_MONEY);
                callableStatement.setInt(1, contractDetail.getContract_id());
                callableStatement.executeUpdate();
                callableStatement.close();
                connection.commit();
            } else {
                connection.rollback();
            }
            connection.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}

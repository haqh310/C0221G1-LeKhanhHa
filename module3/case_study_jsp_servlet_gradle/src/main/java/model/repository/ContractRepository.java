package model.repository;

import model.bean.contract.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    BaseRepository repository = new BaseRepository();
    private final String SELECT_ALL_CONTRACT = "select * from contract";
    private final String SELECT_CONTRACT_BY_NAME = "call select_contract_by_name(?)";
    private final String SELECT_CONTRACT_BY_ID = "select * from contract where contract_id =?";
    private final String INSERT_CONTRACT = "insert into contract(contract_start_date,contract_end_date,contract_deposit,employee_id,customer_id,service_id) " +
            "values(?,?,?,?,?,?)";

    private final String UPDATE_CONTRACT = "update contract set contract_start_date=?, contract_end_date=?, contract_deposit=?,employee_id=? customer_id=?, service_id =? " +
            "where contract_id =? ";
    private final String SELECT_CUSTOMER_CONTRACT = "call select_customer_contract()";
    private final String DELETE_CONTRACT = "delete from contract where contract_id = ?";
    private final String TOTAL_MONEY = "call total_money(?)";

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
                int employee_id = resultSet.getInt("employee_id");
                int customer_id = resultSet.getInt("customer_id");
                int service_id = resultSet.getInt("service_id");
                contracts.add(new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, employee_id, customer_id, service_id));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }


    public List<String[]> findCustomerContract() {
        List<String[]> list = new ArrayList<>();
        Connection connection = repository.connectDataBase();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall(SELECT_CUSTOMER_CONTRACT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String contract_id = resultSet.getString("contract_id");
                String customer_name = resultSet.getString("customer_name");
                String employee_name = resultSet.getString("employee_name");
                String service_name = resultSet.getString("service_name");
                String attach_service_name = resultSet.getString("attach_service_name");
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                String contract_total_money=null;
                CallableStatement callableStatement = connection.prepareCall(TOTAL_MONEY);
                callableStatement.setInt(1,Integer.parseInt(contract_id));
                ResultSet result = callableStatement.executeQuery();
                while (result.next()){
                    contract_total_money = result.getString("total_money");
                }
                callableStatement.close();
                String[] s = {contract_id, customer_name, employee_name, service_name, attach_service_name, contract_total_money, contract_start_date, contract_end_date};
                list.add(s);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String[]> findContractByName(String name) {
        List<String[]> list = new ArrayList<>();
        Connection connection = repository.connectDataBase();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall(SELECT_CONTRACT_BY_NAME);
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String contract_id = resultSet.getString("contract_id");
                String customer_name = resultSet.getString("customer_name");
                String employee_name = resultSet.getString("employee_name");
                String service_name = resultSet.getString("service_name");
                String attach_service_name = resultSet.getString("attach_service_name");
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                String contract_total_money=null;
                CallableStatement callableStatement = connection.prepareCall(TOTAL_MONEY);
                callableStatement.setInt(1,Integer.parseInt(contract_id));
                ResultSet result = callableStatement.executeQuery();
                while (result.next()){
                    contract_total_money = result.getString("total_money");
                }
                callableStatement.close();
                String[] s = {contract_id, customer_name, employee_name, service_name, attach_service_name, contract_total_money, contract_start_date, contract_end_date};
                list.add(s);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Contract findContractById(int id) {
        Contract contract = null;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contract_id = resultSet.getInt("contract_id");
                Date contract_start_date = resultSet.getDate("contract_start_date");
                Date contract_end_date = resultSet.getDate("contract_end_date");
                Double contract_deposit = resultSet.getDouble("contract_deposit");
                int employee_id = resultSet.getInt("employee_id");
                int customer_id = resultSet.getInt("customer_id");
                int service_id = resultSet.getInt("service_id");
                contract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, employee_id, customer_id, service_id);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract;
    }


    public boolean insertContract(Contract contract) {
        boolean rowInsert = false;
        try {
            Connection connection = repository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement(INSERT_CONTRACT);
            statement.setDate(1, contract.getContract_start_date());
            statement.setDate(2, contract.getContract_end_date());
            statement.setDouble(3, contract.getContract_deposit());
            statement.setInt(4, contract.getEmployee_id());
            statement.setInt(5, contract.getCustomer_id());
            statement.setInt(6, contract.getService_id());
            rowInsert = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    public boolean updateContract(int id, Contract contract) {
        boolean rowUpdate = false;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CONTRACT);
            statement.setDate(1, contract.getContract_start_date());
            statement.setDate(2, contract.getContract_end_date());
            statement.setDouble(3, contract.getContract_deposit());
            statement.setDouble(4, contract.getContract_total_money());
            statement.setInt(5, contract.getEmployee_id());
            statement.setInt(6, contract.getCustomer_id());
            statement.setInt(7, contract.getService_id());
            statement.setInt(8, id);
            rowUpdate = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }


    public boolean deleteContract(int contract_id) {
        boolean rowDelete = false;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_CONTRACT);
            statement.setInt(1, contract_id);
            rowDelete = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}

package model.repository;

import model.bean.contract.AttachService;
import model.bean.contract.ContractDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository {
    BaseRepository repository = new BaseRepository();
    private final String INSERT_CONTRACT_DETAIL = "insert into contract_detail(contract_id, attach_service_id, quantity) " +
            "values(?,?,?)";
    private final String SELECT_CONTRACT_DETAIL_BY_CONTRACT_ID = "select * from contract_detail where contract_id =?";
    private final String SELECT_CONTRACT_DETAIL = "select * from contract_detail where contract_detail_id =?";
    private final String SELECT_ALL_ATTACH_SERVICE = "select * from attach_service";
    private final String UPDATE_CONTRACT_DETAIL = "update contract_detail " +
            "set attach_service_id = ?, quantity=? " +
            "where contract_detail_id =?" ;
    private final String DELETE_CONTRACT_DETAIL = "delete from contract_detail where contract_detail_id =?";

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

    public List<ContractDetail> findListContractDetail(int id) {
        List<ContractDetail> contractDetails = new ArrayList<>();
        try {
            Connection connection = repository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement(SELECT_CONTRACT_DETAIL_BY_CONTRACT_ID);
            statement.setInt(1, id);
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

    public ContractDetail findContractDetail(int id) {
        ContractDetail contractDetail = null;
        try {
            Connection connection = repository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement(SELECT_CONTRACT_DETAIL);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int contract_detail_id = resultSet.getInt("contract_detail_id");
                int contract_id = resultSet.getInt("contract_id");
                int attach_service_id = resultSet.getInt("attach_service_id");
                int quantity = resultSet.getInt("quantity");
                contractDetail = new ContractDetail(contract_detail_id, contract_id, attach_service_id, quantity);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractDetail;
    }

    public boolean insertContractDetail(ContractDetail contractDetail) {
        boolean rowInsert = false;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL);
            preparedStatement.setInt(1, contractDetail.getContract_id());
            preparedStatement.setInt(2, contractDetail.getAttach_service_id());
            preparedStatement.setInt(3, contractDetail.getQuantity());
           rowInsert= preparedStatement.executeUpdate()>0;
            preparedStatement.close();
            connection.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    public boolean updateContractDetail(int id,ContractDetail contractDetail ){
        boolean rowUpdate = false;
        Connection connection = repository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CONTRACT_DETAIL);
            statement.setInt(1,contractDetail.getAttach_service_id());
            statement.setInt(2,contractDetail.getQuantity());
            statement.setInt(3,id);
            rowUpdate= statement.executeUpdate()>0;
            statement.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    public boolean deleteContractDetail(int id){
        boolean rowDelete =false;
        Connection connection = repository.connectDataBase();
        try{
            PreparedStatement statement = connection.prepareStatement(DELETE_CONTRACT_DETAIL);
            statement.setInt(1,id);
            rowDelete = statement.executeUpdate() >0;
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowDelete;
    }
}

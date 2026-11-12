package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();									//um resultSet traz os dados na forma de tabela, um objeto com linhas e colunas 
			if (rs.next()) {										//a nossa classe DAO é responsável por pegar pegar esses dados do banco de dados 
				Department dep = new Department();					//relacional que o resultSet traz e transformar em objetos associados
				dep.setId(rs.getInt("DepartmentId"));				//como é feito no bloco ao lado, criando um seller associado ao department, porque é necessário transformar a tabela do resultSet em objetos para ter na memória do computador
				dep.setName(rs.getString("DepName"));				// Quando se executa uma consulta SQL e o resultado vai para o resultSet, esse resultSet aponta para a posição 0, que não contém objeto, somente na posição 1 que contém
				Seller obj = new Seller();							// por isso é importante colocar o if(rs.next()), para testar se veio algum resultado, se a consulta não retornou nenhum registro o rs.next() retorna falso, e aí pula o if e retorna nulo, como no código
 				obj.setId(rs.getInt("Id"));							// agora se deu verdadeiro é porque retornou uma tabela no resultSet com os dados 
				obj.setName(rs.getString("Name"));					// então é possível instanciar o objeto do vendedor associado ao seu departamento, como é feito dentro do bloco if(rs.next()) 
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep);
				return obj;
			}
			return null;
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

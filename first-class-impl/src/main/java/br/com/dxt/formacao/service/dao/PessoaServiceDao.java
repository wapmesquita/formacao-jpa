package br.com.dxt.formacao.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dxt.formacao.domain.Pessoa;
import br.com.dxt.formacao.service.PessoaService;

public class PessoaServiceDao implements PessoaService {

	private Connection abreConexao() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/bancojdbc",
					"java09201501", "java09");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Pessoa salvarPessoa(Pessoa p) {
		Connection con = null;
		PreparedStatement ps = null;

		con = this.abreConexao();
		try {
			ps = con.prepareStatement("insert into pessoa(nome, idade)" +
					" values (?, ?)");
			ps.setString(1, p.name);
			ps.setInt(2, p.age);
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
		}
		return p;
	}

	@Override
	public List<Pessoa> buscarTodasPessoas() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = this.abreConexao();
		try {

			ps = con.prepareStatement
				("select nome, idade from pessoa");
			rs = ps.executeQuery();

			List<Pessoa> lista = new ArrayList<Pessoa>();
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.name = rs.getString("nome");
				p.age = rs.getInt("idade");
				lista.add(p);
			}
			return lista;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
		}
	}

}

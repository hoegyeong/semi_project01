package member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;

public class MemberDAO {
	private SqlSession session;

	public MemberDAO() {
		session = MyAppSqlConfig.getSqlSessionInstance();
	}

	public List<MemberVO> selectAll() {
		return session.selectList("myMember.selectAll");
	}

	public MemberVO selectOne(String email) {
		return session.selectOne("myMember.selectOne", email);
	}

	public void delete(String email) {
		session.delete("myMember.delete", email);
		session.commit();
	}

	public void insertFB(MemberVO m) {
		session.insert("myMember.insertFB", m);
		session.commit();
	}

	public void insertNM(MemberVO m) {
		session.insert("myMember.insertNM", m);
		session.commit();
	}
}

package com.cg.payroll.daoservices;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.payroll.beans.Associate;

public interface AssociateDAO {
	Associate save(Associate associate);
	Associate findOne(int associateId);
	ArrayList<Associate> findAll();
	Associate update(Associate associate);
}

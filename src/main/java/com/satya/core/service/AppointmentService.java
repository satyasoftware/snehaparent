package com.satya.core.service;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.satya.core.bean.Appointment;
import com.satya.core.bean.Provider;
import com.satya.core.enums.AppintmentTypes;

public interface AppointmentService {
	//public Collection<String> getAppointmentThrough();
	
	public Appointment saveAppointment(Appointment appooint);
	public Appointment updateAppointment(Appointment appoint);
	public Collection<Provider> getInstProviders(Long instId,String instType);
	
	public Collection<Appointment> getInstAppointments(Long instId);
	
	public Map<String,Collection> getInstNurseAppointmentsAndEncounters(Long instId,Long nurseId,Collection<Long> doctList);
	
	public Page<Appointment> getInstNurseAppointments(Long instId,Collection<Long> doctList,int pageno);
	public Page<Appointment> getInstNurseAppointments(Long instId,Collection<Long> doctList,Date date,int pageno);
	
	public Page<Appointment> getInstAppointmentsPaging(Long instId,int pageno);
	
	public Appointment findAppointment(Long appointId);
	
	public Collection<String> getAppointmentFor(String instType);
	
	public Collection<AppintmentTypes> getEncounterTypes();
}

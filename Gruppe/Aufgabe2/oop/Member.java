package oop;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Member implements Timespan{
	protected String name;
	protected String surname;
	protected String phoneno;
	protected String instrument;
	protected Date Join;
	protected Date Leave;
	protected List<Event> message;
	protected Date[] proben;
	private int hashCode;

	public Member(String name, String surname, String phoneno, String inst){
		this.name=name;
		this.surname=surname;
		this.phoneno=phoneno;
		this.instrument=inst;
		this.Join=new Date(Long.MAX_VALUE);
		this.Leave=new Date(Long.MAX_VALUE);
		this.message=new ArrayList<Event>();
		this.proben=new Date[3];
		proben[0]=new Date(0);
		proben[1]=new Date(0);
		proben[2]=new Date(0);

	}

	public Member(Member m){
		this(m.name, m.surname, m.phoneno, m.instrument);
		this.Join=m.getBegin();
		this.Leave=m.getEnd();
		this.message=m.getMessage();
		this.proben=m.getProben();
	}

	public String getName(){return name;}
	public String getSurname(){return surname;}
	public String getPhoneNo(){return phoneno;}
	public String getInstrument(){return instrument;}
	public Date getBegin(){return Join;}
	public Date getEnd(){return Leave;}
	public List<Event> getMessage(){return this.message;}
	public Date[] getProben(){return proben;}

	public Member leave(){
		Member m = new Member(this);
		m.Leave= new Date();
		return m;
	}

	public Member join(){
		Member m = new Member(this);
		m.Join=new Date();
		return m;
	}

	public void sendMessage(Event e){
		message.add(e);
	}

	public void replyMessage(Event e, boolean b,String comment){
		if(b) e.accept(comment);
		else e.decline(comment);
		message.remove(e);
	}
	public String toString(){
		return ("Member: " + name + " " + surname + " " + phoneno + " " + instrument);
	}

	public void addProbe(Date m){
		Date k= new Date();
		int t=0;
		for (int i = 0; i<3;i++){
			if (k.after(proben[i])){
				k=proben[i];
				t=i;
			}
		}
		if(proben[t].before(m))proben[t]=m;
		return;
	}

	public boolean isAvailable(Date d) { return true; }

	@Override public boolean equals(Object other) {
		if(this == other) return true;
		if(!(other instanceof Member)) return false;
		Member that = (Member) other;
		return this.name.equals(that.name) &&
			this.surname.equals(that.surname) &&
			this.phoneno.equals(that.phoneno) && 
			this.instrument.equals(that.instrument);
	}

	@Override public int hashCode() {
    if ( hashCode == 0 ) {
      hashCode = name.hashCode() +
      	(surname.hashCode() << 4) +
      	(phoneno.hashCode() << 7) +
      	(instrument.hashCode() << 11);
    }
    return hashCode;
  }
}
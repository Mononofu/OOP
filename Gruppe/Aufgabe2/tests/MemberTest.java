package tests;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Calendar;

import myunit.AbstractTest;
import myunit.UnitTest;
import myunit.BeforeClass;

import oop.Member;
import oop.Substitute;
import oop.MusicGroup;

public class MemberTest extends AbstractTest{
	Date a,b,c,d;

	@BeforeClass
	public void InitializeCommonValues(){
		Calendar cal = Calendar.getInstance();
    	cal.set(2012, 9, 15);
    	a = cal.getTime();

    	cal.set(2012, 10, 4);
    	b = cal.getTime();

	    cal.set(2012, 10, 10);
   		c = cal.getTime();
  
    	cal.set(2012, 10, 5);
    	d = cal.getTime();
	}

	@UnitTest
	public void testMembersAccessors() {
    	Member m = new Member("klaus","Moor", "0815", "Chello");
    	assertEqual(m.getName(), "klaus");
    	assertEqual(m.getPhoneNo(), "0815");
    	assertEqual(m.getInstrument(), "Chello");
        assertEqual(m.getBegin(), new Date(Long.MAX_VALUE));
        assertEqual (m.getBegin(), new Date(Long.MAX_VALUE));
    	assertEqual(m.getEnd(), new Date(Long.MAX_VALUE));
        assertEqual(m.getMessage().size(),new ArrayList<String>().size());
    }
    
    @UnitTest
    public void testMusicGroupMethodsI(){
        MusicGroup g = new MusicGroup("The Goers");
        Member m = new Member("klaus","Moor", "0815", "Chello");
        Member m1= new Member("karl", "koala", "0816", "Guitar");
        Date y= new Date();
        g.addMember(m);
        Date x= new Date();
        g.addMember(m1);
        List<Member> ml=g.getCurrentMembers();
        assertTrue(ml.size()==2); //addMember correct size?
        assertEqual(m.getName(),ml.get(0).getName()); //addMember correct data?
        assertTrue(y.compareTo(ml.get(0).getBegin())<=0 && x.compareTo(ml.get(0).getBegin())>=0); //addMember correct join?

        List<Member> oml=g.getMembers(y,new Date());
        assertEqual(ml,oml); //getMembers, getCurrentMembers working?

        m=ml.get(0);
        y= new Date();
        g.deleteMember(m);
        x= new Date();
        ml=g.getCurrentMembers();
        assertTrue(ml.size()==1); //deleteMember correct size?
        oml=g.getMembers(y,x);
        assertTrue(oml.size()==2);
        assertEqual(m1.getName(),ml.get(0).getName());//deleteMember correct Member deleted?
        assertTrue(y.compareTo(oml.get(1).getEnd())<=0 && x.compareTo(oml.get(1).getEnd())>=0);//deleteMember correct leave?
    }

    @UnitTest
    public void equalityTests() {
        String s = new String("Huber");
        Member m1 = new Member("Sepp", s, "032923932", "Bass");
        Member m2 = new Member("Sepp", "Huber", "032923932", "Bass");
        Member m3 = new Substitute("Sepp", "Huber", "032923932", "Bass");
        Member m4 = new Member("Sepp", "Maier", "032923932", "Bass");

        assertEqual(m1, m2);
        assertEqual(m2, m3);
        assertEqual(m1, m3);    // check transitivity too

        assertNotEqual(m1, m4);
    }
}
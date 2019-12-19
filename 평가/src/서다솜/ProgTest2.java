package ¼­´Ù¼Ø;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProgTest2 {
	Map<String,MemberData> mapList = new Hashtable<String, MemberData>();
	
	
	void mapListAdd(String memberID, String name, String tel, String gender) {
		mapList.put(memberID, new MemberData(memberID,name,tel,gender));
	}
	
	void mapListRemove(String memberID) {
		mapList.remove(memberID);
	}
	
	ArrayList<MemberData> getMapList() {
		Set<String> keyset = mapList.keySet();
		Iterator<String> keyiterator = keyset.iterator();
		ArrayList<MemberData> al = new ArrayList<MemberData>();
		while (keyiterator.hasNext()) {
			String k = keyiterator.next();
			MemberData m = mapList.get(k);
			al.add(new MemberData(m.getMemberID(), m.getName(), m.getTel(), m.getGender()));
		}
		return al;
		
	}

}

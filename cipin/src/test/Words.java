package test;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		String s;
		String fileName1 = "D:\\Workspaces\\jiedui\\src\\text.txt";
		String fileName2 = "D:\\Workspaces\\jiedui\\src\\result.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName1));
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName2));
			StringBuffer sb = new StringBuffer();
			//���ļ����ݴ���StringBuffer��
			while((s = br.readLine()) != null) {
				sb.append(s);
			}
			String str = sb.toString().toLowerCase();
			//�ָ��ַ�������������
			String[] elements = str.split("[^a-zA-Z0-9]+");
			int count = 0;
			Map<String, Integer> myTreeMap = new TreeMap<String, Integer>();
			//�������齫�����Map<String, Integer>��
			for(int i = 0; i < elements.length; i++) {
				if(myTreeMap.containsKey(elements[i])) {
					count = myTreeMap.get(elements[i]);
					myTreeMap.put(elements[i], count + 1);
				}
				else {
					myTreeMap.put(elements[i], 1);
				}
			}                                          
			System.out.println("����ͳ�ƵĽ�������ǰĿ¼result.txt�ļ�");
			//��map.entrySet()ת����list
			List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(myTreeMap.entrySet());
			//ͨ���Ƚ���ʵ������
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
				//��������
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
			});
			int num = 1;
			//�����д���ļ�
			for(Map.Entry<String, Integer> map : list) {
				
				if(num <= sb.length()) {
					bw.write("���ִ�����" + num + "�ĵ���Ϊ��" + map.getKey() + "������Ƶ��Ϊ" + map.getValue() + "��");
					bw.newLine();
					System.out.println(map.getKey() + ":" + map.getValue());
					num++;
				}
				else break;
			}
			bw.write("��ʱ��" + (System.currentTimeMillis() - t1) + "ms");
			br.close();
			bw.close();
			System.out.println("��ʱ��" + (System.currentTimeMillis() - t1) + "ms");
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ���ָ���ļ���");
		} catch (IOException e) {                                    
			System.out.println("�ļ���ȡ����");
		}
	}
}

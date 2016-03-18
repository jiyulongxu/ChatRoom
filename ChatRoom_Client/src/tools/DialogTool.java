package tools;

import java.io.IOException;

import chatUI.DialogUI;
import dataBase.DialogDB;
import dataBase.Figures;

/*
 * ���������Ҫ�����Ự��ع���
 * 1.��ʾ��Ϣ
 * 2.������Ϣ
 */
public class DialogTool {
	
	/*
	 * �������������ʾ��Ϣ
	 * @param from ������JK��
	 * @param msg �ı�����
	 */
	public static void ShowMessage(int from,String msg){
		/*
		 * �ҵ��Ƿ�������ǶԻ��ĶԻ�UI
		 */
		if(DialogDB.dialogDB.containsKey(String.valueOf(from))){
			/*
			 * �еĻ�
			 */
			DialogUI dialog = DialogDB.dialogDB.get(String.valueOf(from));
			dialog.ShowMsg(msg);
			dialog.LetsShack();
		}
		else{
			/*
			 * û�еĻ� A new Msg
			 */
			Figures.list.Hav_Mem_Msg(from);
			
		}
		
		
	}
	
	
	
	
	/*
	 * �����������������Ϣ
	 * @param to ���͸����˵�JK��
	 * @param msg ���͵���Ϣ
	 * @param cc �ܷ���ChatClient
	 */
	public static void SendMessage(int to,String msg){
		
		/*
		 * ������Ϣ
		 */
		try {
			Figures.cc.sendMsg(to, msg);
			System.out.println("������Ϣ�ɹ�");
		} catch (IOException e) {
			System.out.println("������Ϣʧ��");
			e.printStackTrace();
		}
		
	}
}
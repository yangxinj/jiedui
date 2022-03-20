import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;

public class GUI extends JFrame {
	// Create three check boxes to control the display of message
	private JButton jbtRight = new JButton("开始做题");
	private JButton developer = new JButton("上传文件");
	private JButton jb1 = new JButton("继续测试");
	private JCheckBox jchkCentered = new JCheckBox("加减乘除---数字最大值>=50");
	private JCheckBox jchkBold = new JCheckBox("加减带括号---数字最大值>=50");
	private JCheckBox jchkFraction = new JCheckBox("真分数运算---运算符<=3个");
	private JTextField n = new JTextField(8);
	private JTextField m1 = new JTextField(8);
	private JTextField m2 = new JTextField(8);
	private JTextField o = new JTextField(8);
	private JLabel label = new JLabel();
	private static JLabel label0 = new JLabel();
	private static JButton jbnext = new JButton("下一题");
	private static JButton jbsubmit = new JButton("完成");
	private int n1, m11, m22, o1, c = 0, b = 0,f=0;
	int flag0 = 0;
	int flag1 = 0;
	int flag2 = 0;
	int flag3 = 0;
	int flag4 = 0;
	static int flag6 = 0;
	int t = 0;
	int i =1; 
	int count=1;
	ArrayList<String> list = new ArrayList<String>();
	static ArrayList<String> list0 = new ArrayList<String>();
	static int rightAnswer = 0;
	/**
	 * 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
	 */
	private static void InitGlobalFont(Font font) {
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
	}

	public static void main(String[] args) {
		//InitGlobalFont(new Font(Font.DIALOG, Font.PLAIN, 20));
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
        	System.out.println(e);
        }

		InitGlobalFont(new Font("宋体", Font.PLAIN, 15));
		GUI frame = new GUI();
		frame.setTitle("四则运算系统");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600, 450);
		frame.setVisible(true);
	}

	public GUI() {
		
		
		JPanel p1 = new JPanel(){
            protected void paintComponent(Graphics g) {
                ImageIcon icon = new ImageIcon("src/32.jpg");
                 Image img = icon.getImage();
                 g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
                 

             }};;
		p1.setLayout(new GridLayout(4, 2, 5, 5));
		p1.add(new JLabel("请输入题目数量[1,10000]："));
		p1.add(n);
		p1.add(new JLabel("请输入数字最小值[1,100]："));
		p1.add(m1);
		p1.add(new JLabel("请输入数字最大值[1,1000]："));
		p1.add(m2);
		p1.add(new JLabel("请输入运算符个数[1,10]："));
		p1.add(o);

		JPanel jpButtons = new JPanel(){
            protected void paintComponent(Graphics g) {
                ImageIcon icon = new ImageIcon("src/33.jpg");
                 Image img = icon.getImage();
                 g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
                 

             }};;
		jpButtons.add(jbtRight);
		jpButtons.add(developer);
		jbtRight.setMnemonic('V');
		jbtRight.setToolTipText("开始做题");
		jbtRight.setFont(new Font("隶书", Font.PLAIN, 15));
		developer.setHorizontalAlignment(SwingConstants.CENTER);
		developer.setFont(new Font("隶书", Font.PLAIN, 15));
		jbtRight.setBackground(new Color(238,180,180));
		developer.setBackground(new Color(238,180,180));
		setLayout(new BorderLayout());
		add(jpButtons, BorderLayout.SOUTH);

		jchkCentered.setMnemonic('C');
		jchkBold.setMnemonic('B');//键盘助记
		jchkFraction.setMnemonic('F');
		jchkCentered.setFont(new Font("隶书", Font.PLAIN, 15));
		jchkBold.setFont(new Font("隶书", Font.PLAIN, 15));//键盘助记
		jchkFraction.setFont(new Font("隶书", Font.PLAIN, 15));
		

		JPanel jpCheckBoxes = new JPanel(){
            protected void paintComponent(Graphics g) {
                ImageIcon icon = new ImageIcon("src/33.jpg");
                 Image img = icon.getImage();
                 g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
                 

             }};;
		jpCheckBoxes.setLayout(new GridLayout(3, 1));
		jpCheckBoxes.add(jchkCentered);
		jpCheckBoxes.add(jchkBold);
		jpCheckBoxes.add(jchkFraction);
		add(jpCheckBoxes, BorderLayout.NORTH);
		add(p1, BorderLayout.CENTER);
		
		jchkCentered.addActionListener(new ActionListener() {//
			public void actionPerformed(ActionEvent e) {
				c = 1;
			}
		});
		jchkBold.addActionListener(new ActionListener() {//括号
			public void actionPerformed(ActionEvent e) {
				b = 1;
			}
		});
		jchkFraction.addActionListener(new ActionListener() {//括号
			public void actionPerformed(ActionEvent e) {
				f = 1;
			}
		});

		jbtRight.addActionListener(new ButtonListener());// 出题监听器
		developer.addActionListener(new MouseListener()); // 文件上传功能
	}

	private class MouseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			eventOnImport(new JButton());
		}

		private void eventOnImport(JButton jButton) {
			// TODO Auto-generated method stub
			
		}

	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				n1 = Integer.parseInt(n.getText());
				if (n1 <= 0 || n1 > 10000) {
					n.setText("输入数字错误，请输入0到10000的数字哦");
					return;
				}
				flag0 = 1;
			} catch (Exception a) {
				n.setText("不对哦，请重新输入数字哦");
			}
			try {
				m11 = Integer.parseInt(m1.getText());
				if (m11 <= 0 || m11 > 100) {
					m1.setText("输入数字错误，请输入0到100的数字哦");
					return;
				}
				flag1 = 1;
			} catch (Exception a) {
				m1.setText("不对哦，请重新输入数字哦");
			}
			try {
				m22 = Integer.parseInt(m2.getText());
				if (m22 <=0 || m22 > 1000) {
					m2.setText("输入数字错误，请输入50到1000的数字哦");
					return;
				}
				flag2 = 1;

			} catch (Exception a) {
				m2.setText("不对哦，请重新输入数字哦");
			}
			try {
				o1 = Integer.parseInt(o.getText());
				if (o1 <= 0 || o1 > 10) {
					o.setText("输入数字错误，请输入1到10的数字哦");
					return;
				}
				flag3 = 1;
			} catch (Exception a) {
				o.setText("不对哦，请重新输入数字哦");
			}

			if (flag0 == 1 && flag1 == 1 && flag2 == 1 && flag3 == 1) {
				final long t1 = Calendar.getInstance().getTimeInMillis(); // 获取开始时间
				JFrame TiMuFrame = new JFrame();
				TiMuFrame.setTitle("题目");
				TiMuFrame.setSize(700, 400);
				TiMuFrame.setLocationRelativeTo(null);
				TiMuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				TiMuFrame.setVisible(true);

				JPanel panel2 = new JPanel(){
		            protected void paintComponent(Graphics g) {
		                ImageIcon icon = new ImageIcon("src/33.jpg");
		                 Image img = icon.getImage();
		                 g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
		                 

		             }};
				final JTextField text = new JTextField();
				panel2.setLayout(new GridLayout(4, 2));
				JButton jb1=new JButton("重做");
				jb1.setFont(new Font("隶书", Font.PLAIN, 20));
				jb1.setBackground(new Color(245 ,245 ,245));
				label.setText(addProblem());
				
				jbnext.setFont(new Font("隶书", Font.PLAIN, 20));
				jbnext.setBackground(new Color(224,211,203));
				jbsubmit.setFont(new Font("隶书", Font.PLAIN, 20));
				jbsubmit.setBackground(new Color(224,211,203));
				panel2.add(label);
				panel2.add(new JLabel(""));
				final JLabel Jcount=new JLabel("第1题---请输入你的答案：");
				panel2.add(Jcount);
				panel2.add(text);
				
				panel2.add(jb1);
				panel2.add(jbnext);
				panel2.add(jbsubmit);
				TiMuFrame.add(panel2);
				JTextArea tip = new JTextArea();
				tip.setFont(new Font("隶书", Font.PLAIN, 15));
				tip.setText("贴心小提示：\n1.请在文本框里填写算式答案\n"
						+ "2.如果输入错误或更改答案请按重做按钮    \n3.继续做题请按下一题按钮\n4.结束此轮计算请按完成按钮");
				
				//jbnext.setBackground(new Color(238,180,180));
				tip.setEditable(false);
				panel2.add(tip);
				/*text.addKeyListener(new KeyAdapter()
				{
					public void keyTyped(KeyEvent e)
					{
						char c=e.getKeyChar();
						if (!(c >= '0' && c <= '9')) {
		                    text.setText("输入非数字，请重做！");
		                }
					}
				});*/
				jb1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						text.setText("");
						
					}
				});
				 
		
				jbnext.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String question = label.getText();
						
						String result2=text.getText();//分数
						//double result = Double.parseDouble(result2);
						String m33=text.getText();
						String ifRight = "";
						String message = "";
						/*try {
							
							Boolean strResult = m33.matches("-?[0-9]+.?[0-9]*");     
							 if(strResult == false) {  
								            text.setText("输入非数字，请重做！");
								        
								        } 
								
							} catch (Exception a) {
								text.setText("不对哦，请重新输入数字哦");
							}*/
						i++;
						if(i==n1)
						{
								jbnext.setEnabled(false);
						}
					   Jcount.setText("第"+i+"题---请输入你的答案：");
						
						if (flag4 == 1) {
							if (Operation.sum == result2) {
								ifRight = "正确";
								rightAnswer++;
								t = t+5;
							} else {
								ifRight = "错误";
							}
							message = question + "， " + "你的答案：" + result2 + "， " + "正确答案： " + Operation.sum + "， 结果： "
									+ ifRight;
						}
						if (flag4 == 0) {
							double result = Double.parseDouble(result2);
							if (Operation1.sum == result) {
								ifRight = "正确";
								rightAnswer++;
								t = t+5;
							} else {
								ifRight = "错误";
							}
							message = question + "， " + "你的答案：" + result + "， " + "正确答案： " + Operation1.sum + "， 结果： "
									+ ifRight;
						}
						if (flag4 == -1) {
							double result = Double.parseDouble(result2);
							if (Operation2.sum == result) {
								ifRight = "正确";
								rightAnswer++;
								t = t+5;
							} else {
								ifRight = "错误";
							}
							message = question + "， " + "你的答案：" + result + "， " + "正确答案： " + Operation2.sum + "， 结果： "
									+ ifRight;
						}
						list.add(message);
						text.setText("");
						String answer = "";
						if (flag4 == 1) {
							answer = Operation.Operation(n1, m11, m22, c, o1);
						}
						if (flag4 == 0) {
							answer = Operation1.Operation(n1, m11, m22, c, o1);
						}
						if (flag4 == -1) {
							answer = Operation2.Operation(n1, m11, m22, c, o1);
						}
						// System.out.print(1);
						label.setText("题目：" + answer + "=");
						Font font = new Font(Font.DIALOG, Font.PLAIN, 20);
						label.setFont(font);
						
					}
					
				});
                
				
				jbsubmit.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						String question = label.getText();
						
						String result2=text.getText();
						//double result = Double.parseDouble(result2);
						String ifRight = "";
						String message = "";
						/*try {
							
							Boolean strResult = m33.matches("-?[0-9]+.?[0-9]*");     
							 if(strResult == false) {  
								            text.setText("输入非数字，请重做！");
								        
								        } 
								
							} catch (Exception a) {
								text.setText("不对哦，请重新输入数字哦");
							}*/
						
					

						
						if (flag4 == 1) {
							if (Operation.sum == result2) {
								ifRight = "正确";
								rightAnswer++;
								t = t+5;
							} else {
								ifRight = "错误";
							}
							message = question + "， " + "你的答案：" + result2 + "， " + "正确答案： " + Operation.sum + "， 结果： "
									+ ifRight;
						}
						if (flag4 == 0) {
							double result = Double.parseDouble(result2);
							if (Operation1.sum == result) {
								ifRight = "正确";
								rightAnswer++;
								t = t+5;
							} else {
								ifRight = "错误";
							}
							message = question + "， " + "你的答案：" + result + "， " + "正确答案： " + Operation1.sum + "， 结果： "
									+ ifRight;
						}
						if (flag4 == -1) {
							double result = Double.parseDouble(result2);
							if (Operation2.sum == result) {
								ifRight = "正确";
								rightAnswer++;
								t = t+5;
							} else {
								ifRight = "错误";
							}
							message = question + "， " + "你的答案：" + result + "， " + "正确答案： " + Operation2.sum + "， 结果： "
									+ ifRight;
						}
						list.add(message);
						text.setText("");
						String answer = "";
						if (flag4 == 1) {
							answer = Operation.Operation(n1, m11, m22, c, o1);
						}
						if (flag4 == 0) {
							answer = Operation1.Operation(n1, m11, m22, c, o1);
						}
						if (flag4 == -1) {
							answer = Operation2.Operation(n1, m11, m22, c, o1);
						}
						// System.out.print(1);
						label.setText("恭喜你完成此轮测试！");
						Font font = new Font(Font.DIALOG, Font.PLAIN, 20);
						label.setFont(font);
						
						// TODO Auto-generated method stub
						long t2 = Calendar.getInstance().getTimeInMillis(); // 获取结束时间
						JFrame resultFrame = new JFrame();
						resultFrame.setTitle("题目");
						resultFrame.setSize(500, 500);
						resultFrame.setLocationRelativeTo(null);
						resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						resultFrame.setVisible(true);
						int size = list.size();
                      
						JPanel panel = new JPanel(){
				            protected void paintComponent(Graphics g) {
				                ImageIcon icon = new ImageIcon("src/45.jpeg");
				                 Image img = icon.getImage();
				                 g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());
				                 

				             }};;
						panel.add(new JLabel(
								 "  正确个数：" + rightAnswer +"做题总数： " + size + " " +"分数："+t+" "+ "  用时(')：" + (t2 - t1) / 1000));
						setLayout(new GridLayout(100, 1, 5, 5));
						for (int i = 0; i < size; i++) {
							panel.add(new JLabel(list.get(i)));
						}
						resultFrame.add(panel);
					}
				});
			} else
				return;
			// c = 0;
			// b = 0;
		}
	}

	public String addProblem() {
	    
		Font font = new Font(Font.DIALOG, Font.PLAIN, 20);
		label.setFont(font);
		String problem;
		if (f==1&&b==0&&c==0) {
			flag4 = 1;
			problem = Operation.Operation(n1, m11, m22, c, o1);//真分数   加一个按钮  ，并更改最大最小值的设置
		} else if (c==1&&f==0&&b==0) {
			flag4 = 0;
			problem = Operation1.Operation(n1, m11, m22, c, o1);//加减乘除无括号  √c
		} else { 
			flag4 = -1;
			problem = Operation2.Operation(n1, m11, m22, c, o1);//只有加减但带括号 √b
		} 
		 label.setText(problem);
		 
		return "题目：" + problem + "=";
		
		
		
	}
}
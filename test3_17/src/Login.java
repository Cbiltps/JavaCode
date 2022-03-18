import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurFace extends JFrame implements ActionListener {
    JLabel jl1,jl2,jl3;
    JLabel label;
    JTextField jtf;
    JPasswordField jpf;
    JButton jb1,jb2,jb3;
    ImageIcon background;
    JPanel jp1,jp2,jp3,jp4;
    JPanel myPanel;//要放置的背景

    public SurFace(){
        jl1=new JLabel("账号：");
        jl2=new JLabel("密码：");

        jtf=new JTextField(16);
        jpf=new JPasswordField(16);
        jb1=new JButton("登录");
        jb2=new JButton("取消");
        jb3=new JButton("清空");

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();

        background = new ImageIcon("images/背景.jpg");	//创建一个背景图片
        label = new JLabel(background);	//把背景图片添加到标签里
        label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());	//把标签设置为和图片等高等宽
        myPanel = (JPanel)this.getContentPane();//把我的面板设置为内容面板
        myPanel.setOpaque(false);//把我的面板设置为不可视
        myPanel.setLayout(new FlowLayout());//把我的面板设置为流动布局
        this.getLayeredPane().setLayout(null);//把分层面板的布局置空

        jp1.add(jl1);
        jp1.add(jtf);
        jp2.add(jl2);
        jp2.add(jpf);
        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);

//		jp4.add(jl3);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));		//把标签添加到分层面板的最底层

        //监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        this.setTitle("欢迎来到登录界面！");
        this.setSize(400,300);
        this.setLocation(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new SurFace();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
	/*jb1=new JButton("登录");
		jb2=new JButton("取消");
		jb3=new JButton("清空");
		JTextField jtf;
	JPasswordField jpf;*/
        if(e.getSource()==jb1) {
            String name="user";
            String psw="123456";

            String j1=jtf.getText();
            String p1=jpf.getText();

            if(name.equals(j1)&&psw.equals(p1)) {
                JOptionPane.showMessageDialog(this, "登陆成功");

            }else {
                JOptionPane.showMessageDialog(this, "登陆失败");
            }

        }else if(e.getSource()==jb2) {
            this.setVisible(false);

        }else if(e.getSource()==jb3) {
            jtf.setText(null);
            jpf.setText(null);

        }

    }
}

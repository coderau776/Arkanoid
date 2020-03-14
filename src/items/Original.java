package items;

import javax.swing.JFrame;

public class Original {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		Gameplay g = new Gameplay();
		jf.setBounds(10,10,700,600);
		jf.setTitle("arkanoid");
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(g);
	}
}

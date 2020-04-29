import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Mitarbeiter extends JFrame {

    private JTextField tname;
    private JTextField tnachname;
    private JButton addButton;
    private JPanel BerinPanel;
    private JTextField ttc;
    private JLabel Tc;
    public static Connection con = null;
    public static Statement stmt = null;
    public static ResultSet rslt = null;
    private JLabel Name;
    private JLabel Nachname;


    public Mitarbeiter() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Muayne Gözlem Raporu");
        add(BerinPanel);
        setSize(600, 300);
        this.setContentPane(BerinPanel);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = tname.getText();
                String nachname = tnachname.getText();
                String tc= ttc.getText();

                try {
                    stmt.executeUpdate("INSERT INTO software(MitarbeiterName,MitarbeiterNachname,MitarbeiterTcNo) VALUES('"+ name +"','"+ nachname+ "','"+ tc+ "')");

                    } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new Mitarbeiter();
        frame.setVisible(true);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;database=master;";

            con = DriverManager.getConnection(url, "software", "123456");
            stmt = con.createStatement();
            ResultSet resultQuery = stmt.executeQuery("Select * From software");
            System.out.println("Bağlandı");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}





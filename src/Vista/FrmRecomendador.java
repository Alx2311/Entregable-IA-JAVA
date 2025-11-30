package Vista;

import DAO.peliculadao;
import Controller.Controller;
import DML.Pelicula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FrmRecomendador extends JFrame {

    JComboBox<String> cboGenero;
    JTextArea txtResultados;
    JButton btnRecomendar;

    public FrmRecomendador() {
        setTitle("Recomendador de Películas");
        setSize(400, 300);
        setLayout(null);

        cboGenero = new JComboBox<>();
        cboGenero.addItem("accion");
        cboGenero.addItem("comedia");
        cboGenero.addItem("terror");
        cboGenero.addItem("drama");
        cboGenero.setBounds(20, 20, 150, 30);
        add(cboGenero);

        btnRecomendar = new JButton("Recomendar");
        btnRecomendar.setBounds(200, 20, 150, 30);
        add(btnRecomendar);

        txtResultados = new JTextArea();
        JScrollPane sp = new JScrollPane(txtResultados);
        sp.setBounds(20, 70, 330, 170);
        add(sp);

        btnRecomendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genero = cboGenero.getSelectedItem().toString();

                peliculadao dao = new peliculadao();
                List<Pelicula> lista = dao.obtenerPorGenero(genero);

                Controller c = new Controller();
                txtResultados.setText(c.recomendar(lista, 0));
            }
        });

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FrmRecomendador();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

//bibliotecas para a imagem do Desktop Pane
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/*  --- Para estudos futuros ---
    Para alterar a imagem do Desktop Pane é preciso importar as bibliotecas acima e clicar no componente em "Customize Code..." colocando o código abaixo:

ImageIcon icon = new ImageIcon(getClass().getResource("/imagem/fundo_desktop.png"));
Image image = icon.getImage();
desktopPaneControl = new javax.swing.JDesktopPane(){

    public void paintComponent(Graphics g){
        g.drawImage(image,0,0,getWidth(),getHeight(),this);
    }
};
*/

import dao.AlunoDAO;
import dao.DisciplinaDAO;
import dao.ProfessorDAO;
import helpers.Helpers;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Aluno;
import models.Disciplina;
import models.Professor;

/**
 *
 * @author willian
 */
public class FrmUnijorge extends javax.swing.JFrame {
    
    List<Aluno> listaDeAlunos;

    /**
     * Creates new form FrmProfessor
     */
    public FrmUnijorge() {
        initComponents();
    }

  
    public void ListarProfessores() {
            try {
                ProfessorDAO dao = new ProfessorDAO();
                List<Professor> lista = dao.listarProfessores();

                cbprofessor.removeAllItems();

                for(Professor professor : lista){
                    // Adiciona o objeto 'professor' inteiro, mas o ToString em Professor.models mostra o nome
                    //Obs: para funcionar precisei ir na interface > propriedades > code > e mudar tipo de parâmetro para <Object>
                    cbprofessor.addItem(professor); 
                }
            } catch (Exception e) {
                 // Dica extra: Nunca deixe o catch vazio, senão você não vê os erros
                 JOptionPane.showMessageDialog(null, "Erro ao listar: " + e);
            }
        }
        
    public void CarregarTabelaProfessores() {
        try {
            //1 - instanciar um objeto da classe ProfessorDAO
            ProfessorDAO dao = new ProfessorDAO();
            List<Professor> lista = dao.listarProfessores();

            //2 - Criar o DefaultTableModel (conteúdo da tabela)
            DefaultTableModel conteudo = (DefaultTableModel) tabelaProfessores.getModel();
            conteudo.setNumRows(0);

            //3 - Montar o conteúdo para exibir na tabela
            for (Professor professor : lista) {
                conteudo.addRow(new Object[]{
                    professor.getId_professor(),
                    professor.getNome(),
                    professor.getEmail(),
                    professor.getEspecialidade(),
                    professor.getEndereco(),
                    professor.getTelefoneCelular(),
                    professor.getWhatsApp()
                });
            }
        } catch (Exception e) {
        }
    }
        
    
    public void CarregarTabelaDisciplinas() {
        try {
            //1 - instanciar um objeto da classe ProfessorDAO
            DisciplinaDAO dao = new DisciplinaDAO();
            List<Disciplina> lista = dao.listarDisciplinas();

            //2 - Criar o DefaultTableModel (conteúdo da tabela)
            DefaultTableModel conteudo = (DefaultTableModel) tabelaDisciplinas.getModel();
            conteudo.setNumRows(0);

            //3 - Montar o conteúdo para exibir na tabela
        for (Disciplina disciplina : lista) {
            conteudo.addRow(new Object[]{
                disciplina.getId_disciplina(),
                disciplina.getNome(),
                disciplina.getCarga_horaria(),
                disciplina.getSemestre(),
                disciplina.getNomeProfessor()
            });
            }
        } catch (Exception e) {
        }
    }
    
        public void CarregarTabelaAlunos() {
        try {
            //1 - instanciar um objeto da classe ProfessorDAO
            AlunoDAO dao = new AlunoDAO();
            List<Aluno> lista = dao.listarAlunos();
            
            listaDeAlunos = dao.listarAlunos();

            //2 - Criar o DefaultTableModel (conteúdo da tabela)
            DefaultTableModel conteudo = (DefaultTableModel) tabelaAlunos.getModel();
            conteudo.setNumRows(0);

            //3 - Montar o conteúdo para exibir na tabela
        for (Aluno aluno : lista) {
            conteudo.addRow(new Object[]{
                aluno.getId_aluno(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getCurso(),
                aluno.getWhatsapp()
            });
            }
        } catch (Exception e) {
        }
    }
        
        public void AtualizarListas(){
            ListarProfessores();
            //ListarAlunos();
            CarregarTabelaProfessores();
            CarregarTabelaDisciplinas();
            CarregarTabelaAlunos();
            //ListarDisciplinas();
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        guias = new javax.swing.JTabbedPane();
        painelProfessor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnome_professor = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttelefone = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtwhatsapp = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtendereco = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtespecialidade = new javax.swing.JTextField();
        btnexcluir = new javax.swing.JButton();
        btnalterar = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        txtid_professor = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnlimparProfessor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtpesquisa = new javax.swing.JTextField();
        btnpesquisa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProfessores = new javax.swing.JTable();
        painelDisciplina = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtid_disciplina = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtnome_disciplina = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtsemestre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtcarga_horaria = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbprofessor = new javax.swing.JComboBox<>();
        btnsalvarDisciplina = new javax.swing.JButton();
        btnalterarDisciplina = new javax.swing.JButton();
        btnexcluirDisciplina = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnlimparDisciplina = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtpesquisaDisciplina = new javax.swing.JTextField();
        btnpesquisaDisciplina = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDisciplinas = new javax.swing.JTable();
        painelAluno = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtid_aluno = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtnome_aluno = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtemail_aluno = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtcelular_aluno = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        txtwhatsapp_aluno = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtendereco_aluno = new javax.swing.JTextField();
        btnsalvar_aluno = new javax.swing.JButton();
        btnalterar_aluno = new javax.swing.JButton();
        btnexcluir_aluno = new javax.swing.JButton();
        txtdata_nascimento_aluno = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        txtcurso_aluno = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnlimparAluno = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtpesquisaAluno = new javax.swing.JTextField();
        btnpesquisaAluno = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAlunos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagem/fundo_desktop.png"));
        Image image = icon.getImage();
        desktopPaneControl = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        btnmatricula = new javax.swing.JButton();
        btnnotas = new javax.swing.JButton();
        btnGerenciarMatricula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador - Jorge Amado");
        setMinimumSize(new java.awt.Dimension(916, 500));
        setPreferredSize(new java.awt.Dimension(916, 650));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FACULDADE JORGE AMADO - GESTÃO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(239, 239, 239))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, -1));

        painelProfessor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Código:");
        painelProfessor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nome:");
        painelProfessor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        txtnome_professor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelProfessor.add(txtnome_professor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 189, -1));

        txtemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelProfessor.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 188, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("E-mail:");
        painelProfessor.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Celular:");
        painelProfessor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        try {
            txttelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txttelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelProfessor.add(txttelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 188, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Whatsapp:");
        painelProfessor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        try {
            txtwhatsapp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtwhatsapp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelProfessor.add(txtwhatsapp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 188, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Endereço:");
        painelProfessor.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        txtendereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelProfessor.add(txtendereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 367, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Especialidade:");
        painelProfessor.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        txtespecialidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelProfessor.add(txtespecialidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 367, -1));

        btnexcluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnexcluir.setText("Excluir");
        btnexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirActionPerformed(evt);
            }
        });
        painelProfessor.add(btnexcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, -1));

        btnalterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnalterar.setText("Alterar");
        btnalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarActionPerformed(evt);
            }
        });
        painelProfessor.add(btnalterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, -1));

        btnsalvar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnsalvar.setText("Salvar");
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });
        painelProfessor.add(btnsalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        txtid_professor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtid_professor.setText(".");
        painelProfessor.add(txtid_professor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 22, -1));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/plano_fundo.png"))); // NOI18N
        painelProfessor.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 0, 384, -1));

        btnlimparProfessor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnlimparProfessor.setText("Limpar");
        btnlimparProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparProfessorActionPerformed(evt);
            }
        });
        painelProfessor.add(btnlimparProfessor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, -1, -1));

        guias.addTab("Professor", painelProfessor);

        txtpesquisa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisaKeyPressed(evt);
            }
        });

        btnpesquisa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnpesquisa.setText("Pesquisar");
        btnpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisaActionPerformed(evt);
            }
        });

        tabelaProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID professor", "Nome", "E-mail", "Especialidade", "Endereço", "Celular", "WhatsApp"
            }
        ));
        tabelaProfessores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProfessoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProfessores);
        if (tabelaProfessores.getColumnModel().getColumnCount() > 0) {
            tabelaProfessores.getColumnModel().getColumn(3).setHeaderValue("Especialidade");
            tabelaProfessores.getColumnModel().getColumn(6).setHeaderValue("WhatsApp");
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnpesquisa)
                        .addGap(0, 351, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(437, Short.MAX_VALUE))
        );

        guias.addTab("Consulta Professor", jPanel3);

        painelDisciplina.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Código:");
        painelDisciplina.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 52, -1, -1));

        txtid_disciplina.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtid_disciplina.setText(".");
        painelDisciplina.add(txtid_disciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 52, 22, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Nome:");
        painelDisciplina.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 95, -1, -1));

        txtnome_disciplina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelDisciplina.add(txtnome_disciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 92, 282, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Carga Horária:");
        painelDisciplina.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 133, -1, -1));

        txtsemestre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelDisciplina.add(txtsemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 174, 282, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Semestre:");
        painelDisciplina.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 177, -1, -1));

        txtcarga_horaria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelDisciplina.add(txtcarga_horaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 130, 282, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Professor:");
        painelDisciplina.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 221, -1, -1));

        cbprofessor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbprofessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbprofessorActionPerformed(evt);
            }
        });
        painelDisciplina.add(cbprofessor, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 218, 282, -1));

        btnsalvarDisciplina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnsalvarDisciplina.setText("Salvar");
        btnsalvarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarDisciplinaActionPerformed(evt);
            }
        });
        painelDisciplina.add(btnsalvarDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        btnalterarDisciplina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnalterarDisciplina.setText("Alterar");
        btnalterarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarDisciplinaActionPerformed(evt);
            }
        });
        painelDisciplina.add(btnalterarDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        btnexcluirDisciplina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnexcluirDisciplina.setText("Excluir");
        btnexcluirDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluirDisciplinaActionPerformed(evt);
            }
        });
        painelDisciplina.add(btnexcluirDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/plano_fundo.png"))); // NOI18N
        painelDisciplina.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 0, 384, -1));

        btnlimparDisciplina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnlimparDisciplina.setText("Limpar");
        btnlimparDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparDisciplinaActionPerformed(evt);
            }
        });
        painelDisciplina.add(btnlimparDisciplina, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        guias.addTab("Disciplina", painelDisciplina);

        txtpesquisaDisciplina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtpesquisaDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesquisaDisciplinaActionPerformed(evt);
            }
        });
        txtpesquisaDisciplina.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisaDisciplinaKeyPressed(evt);
            }
        });

        btnpesquisaDisciplina.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnpesquisaDisciplina.setText("Pesquisar");
        btnpesquisaDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisaDisciplinaActionPerformed(evt);
            }
        });

        tabelaDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Disciplina", "Nome", "Carga Horaria", "Semestre", "Professor"
            }
        ));
        tabelaDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDisciplinasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaDisciplinas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(txtpesquisaDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnpesquisaDisciplina)
                .addContainerGap(357, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpesquisaDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesquisaDisciplina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );

        guias.addTab("Consultar Disciplinas", jPanel4);

        painelAluno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Código:");
        painelAluno.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        txtid_aluno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtid_aluno.setText(".");
        painelAluno.add(txtid_aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 22, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Nome:");
        painelAluno.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        txtnome_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelAluno.add(txtnome_aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 189, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("E-mail:");
        painelAluno.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        txtemail_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelAluno.add(txtemail_aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 188, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Celular:");
        painelAluno.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        try {
            txtcelular_aluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcelular_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelAluno.add(txtcelular_aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 188, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Whatsapp:");
        painelAluno.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        try {
            txtwhatsapp_aluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtwhatsapp_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelAluno.add(txtwhatsapp_aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 188, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Nascimento:");
        painelAluno.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Endereço:");
        painelAluno.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        txtendereco_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelAluno.add(txtendereco_aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 367, -1));

        btnsalvar_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnsalvar_aluno.setText("Salvar");
        btnsalvar_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvar_alunoActionPerformed(evt);
            }
        });
        painelAluno.add(btnsalvar_aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, -1, -1));

        btnalterar_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnalterar_aluno.setText("Alterar");
        btnalterar_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterar_alunoActionPerformed(evt);
            }
        });
        painelAluno.add(btnalterar_aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        btnexcluir_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnexcluir_aluno.setText("Excluir");
        btnexcluir_aluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexcluir_alunoActionPerformed(evt);
            }
        });
        painelAluno.add(btnexcluir_aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, -1, -1));

        try {
            txtdata_nascimento_aluno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdata_nascimento_aluno.setToolTipText("");
        txtdata_nascimento_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelAluno.add(txtdata_nascimento_aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 188, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Curso:");
        painelAluno.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        txtcurso_aluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        painelAluno.add(txtcurso_aluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 367, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/plano_fundo.png"))); // NOI18N
        painelAluno.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 0, 384, -1));

        btnlimparAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnlimparAluno.setText("Limpar");
        btnlimparAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparAlunoActionPerformed(evt);
            }
        });
        painelAluno.add(btnlimparAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, -1, -1));

        guias.addTab("Aluno", painelAluno);

        txtpesquisaAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtpesquisaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesquisaAlunoActionPerformed(evt);
            }
        });
        txtpesquisaAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisaAlunoKeyPressed(evt);
            }
        });

        btnpesquisaAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnpesquisaAluno.setText("Pesquisar");
        btnpesquisaAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisaAlunoActionPerformed(evt);
            }
        });

        tabelaAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Aluno", "Nome", "E-mail", "Curso", "Whatsapp"
            }
        ));
        tabelaAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAlunosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaAlunos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(txtpesquisaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnpesquisaAluno)
                .addContainerGap(357, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpesquisaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpesquisaAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );

        guias.addTab("Consultar Aluno", jPanel6);

        javax.swing.GroupLayout desktopPaneControlLayout = new javax.swing.GroupLayout(desktopPaneControl);
        desktopPaneControl.setLayout(desktopPaneControlLayout);
        desktopPaneControlLayout.setHorizontalGroup(
            desktopPaneControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        desktopPaneControlLayout.setVerticalGroup(
            desktopPaneControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );

        btnmatricula.setText("Matricula");
        btnmatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmatriculaActionPerformed(evt);
            }
        });

        btnnotas.setText("Notas");
        btnnotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnotasActionPerformed(evt);
            }
        });

        btnGerenciarMatricula.setText("Gerenciar");
        btnGerenciarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenciarMatriculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGerenciarMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnmatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(desktopPaneControl)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnmatricula)
                .addGap(18, 18, 18)
                .addComponent(btnGerenciarMatricula)
                .addGap(18, 18, 18)
                .addComponent(btnnotas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(desktopPaneControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 397, Short.MAX_VALUE))
        );

        guias.addTab("Gerenciar aluno", jPanel2);

        getContentPane().add(guias, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 122, 910, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisaActionPerformed
        //Botão Pesquisar
        //1 - receber o texto
        String nome = "%" + txtpesquisa.getText() + "%";

        //1 - instanciar um objeto da classe ProfessorDAO
        ProfessorDAO dao = new ProfessorDAO();
        List<Professor> lista = dao.buscarProfessorPeloNome(nome);

        //2 - Criar o DefaultTableModel (conteúdo da tabela)
        DefaultTableModel conteudo = (DefaultTableModel) tabelaProfessores.getModel();
        conteudo.setNumRows(0);

        //3 - Montar o conteúdo para exibir na tabela
        for (Professor professor : lista) {
            conteudo.addRow(new Object[]{
                professor.getId_professor(),
                professor.getNome(),
                professor.getEmail(),
                professor.getEspecialidade(),
                professor.getEndereco(),
                professor.getTelefoneCelular(),
                professor.getWhatsApp()
            });
        }
    }//GEN-LAST:event_btnpesquisaActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        // Botão Salvar Professor
        try {
            //1 - Receber os dados
            Professor obj = new Professor();

            obj.setNome(txtnome_professor.getText());
            obj.setEmail(txtemail.getText());
            obj.setEspecialidade(txtespecialidade.getText());
            obj.setEndereco(txtendereco.getText());
            obj.setTelefoneCelular(txttelefone.getText());
            obj.setWhatsApp(txtwhatsapp.getText());

            //2 - Criar o objeto DAO pra salvar no banco
            ProfessorDAO dao = new ProfessorDAO();
            dao.cadastrarProfessor(obj);

            //Limpar campos de Texto
            new Helpers().limparTela(painelProfessor);
            txtid_professor.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Preencha os dados");
        }
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void btnalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarActionPerformed
        //Botão Alterar
        try {
            //1 - Receber os dados
            Professor obj = new Professor();
            
            obj.setNome(txtnome_professor.getText());
            obj.setEmail(txtemail.getText());
            obj.setEspecialidade(txtespecialidade.getText());
            obj.setEndereco(txtendereco.getText());
            obj.setTelefoneCelular(txttelefone.getText());
            obj.setWhatsApp(txtwhatsapp.getText());
            
            obj.setId_professor(Integer.parseInt(txtid_professor.getText()));
            //2 - Criar o objeto DAO para salvar no banco

            ProfessorDAO dao = new ProfessorDAO();
            dao.alterarProfessor(obj);

            AtualizarListas();

            //Limpar campos de Texto
            new Helpers().limparTela(painelProfessor);
            txtid_professor.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione um professor");
        }
    }//GEN-LAST:event_btnalterarActionPerformed

    private void btnexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirActionPerformed
        //Excluir
        try {
            int id = Integer.parseInt(txtid_professor.getText());

            ProfessorDAO dao = new ProfessorDAO();
            dao.excluirProfessor(id);

            //Atualizar listas
            AtualizarListas();

            //Limpar campos de Texto
            new Helpers().limparTela(painelProfessor);
            txtid_professor.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione um professor");
        }
    }//GEN-LAST:event_btnexcluirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //Executa quando ativar o formulário
        AtualizarListas();
    }//GEN-LAST:event_formWindowActivated

    private void tabelaProfessoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProfessoresMouseClicked
        // Clique em um ítem da tabela
        guias.setSelectedIndex(0);

        //Pegar os dados
        txtid_professor.setText(tabelaProfessores.getValueAt(tabelaProfessores.getSelectedRow(), 0).toString());
        txtnome_professor.setText(tabelaProfessores.getValueAt(tabelaProfessores.getSelectedRow(), 1).toString());
        txtemail.setText(tabelaProfessores.getValueAt(tabelaProfessores.getSelectedRow(), 2).toString());
        txtespecialidade.setText(tabelaProfessores.getValueAt(tabelaProfessores.getSelectedRow(), 3).toString());
        txtendereco.setText(tabelaProfessores.getValueAt(tabelaProfessores.getSelectedRow(), 4).toString());
        txttelefone.setText(tabelaProfessores.getValueAt(tabelaProfessores.getSelectedRow(), 5).toString());
        txtwhatsapp.setText(tabelaProfessores.getValueAt(tabelaProfessores.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_tabelaProfessoresMouseClicked

    private void txtpesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisaKeyPressed
        //1 - receber o texto
        String nome = "%" + txtpesquisa.getText() + "%";

        //1 - instanciar um objeto da classe ProfessorDAO
        ProfessorDAO dao = new ProfessorDAO();
        List<Professor> lista = dao.buscarProfessorPeloNome(nome);

        //2 - Criar o DefaultTableModel (conteúdo da tabela)
        DefaultTableModel conteudo = (DefaultTableModel) tabelaProfessores.getModel();
        conteudo.setNumRows(0);

        //3 - Montar o conteúdo para exibir na tabela
        for (Professor professor : lista) {
            conteudo.addRow(new Object[]{
                professor.getId_professor(),
                professor.getNome(),
                professor.getEmail(),
                professor.getEspecialidade(),
                professor.getEndereco(),
                professor.getTelefoneCelular(),
                professor.getWhatsApp()
            });
        }

    }//GEN-LAST:event_txtpesquisaKeyPressed

    private void btnsalvarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarDisciplinaActionPerformed
// Salvar Disciplina
        try {
            //1 - Receber os dados
            Disciplina obj = new Disciplina();

            obj.setNome(txtnome_disciplina.getText());
            obj.setCarga_horaria(Integer.parseInt(txtcarga_horaria.getText()));
            obj.setSemestre(Integer.parseInt(txtsemestre.getText()));

            // --- PARA REVISAR ---
            // Pegamos o item selecionado e convertemos para Professor
            Professor professorSelecionado = (Professor) cbprofessor.getSelectedItem();
            
            // Agora temos acesso ao ID daquele professor
            obj.setId_professor(professorSelecionado.getId_professor());
            // ---------------------------

            //2 - Criar o objeto DAO pra salvar no banco
            DisciplinaDAO dao = new DisciplinaDAO();
            dao.cadastrarDisciplina(obj);

            //Limpar campos de Texto
            new Helpers().limparTela(painelDisciplina);
            txtid_disciplina.setText(".");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Preencha os dados corretamente. Erro: " + e);
            System.out.println(e);
        }
    }//GEN-LAST:event_btnsalvarDisciplinaActionPerformed

    private void btnalterarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarDisciplinaActionPerformed
        //Botão Alterar - Disciplina
        try {
            //1 - Receber os dados
            //1 - Receber os dados
            Disciplina obj = new Disciplina();

            obj.setNome(txtnome_disciplina.getText());
            obj.setCarga_horaria(Integer.parseInt(txtcarga_horaria.getText()));
            obj.setSemestre(Integer.parseInt(txtsemestre.getText()));
            
            obj.setId_disciplina(Integer.parseInt(txtid_disciplina.getText()));
            // --- PARA REVISAR ---
            // Pegamos o item selecionado e convertemos para Professor
            Professor professorSelecionado = (Professor) cbprofessor.getSelectedItem();
            
            // Agora temos acesso ao ID daquele professor
            obj.setId_professor(professorSelecionado.getId_professor());
            //2 - Criar o objeto DAO para salvar no banco

            DisciplinaDAO dao = new DisciplinaDAO();
            dao.alterarDisciplina(obj);

            AtualizarListas();

            //Limpar campos de Texto
            new Helpers().limparTela(painelDisciplina);
            txtid_professor.setText(".");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione uma disciplina");
        }
    }//GEN-LAST:event_btnalterarDisciplinaActionPerformed

    private void btnexcluirDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluirDisciplinaActionPerformed
        //Excluir disciplina
        try {
            int id = Integer.parseInt(txtid_disciplina.getText());

            DisciplinaDAO dao = new DisciplinaDAO();
            dao.excluirDisciplina(id);

            AtualizarListas();

            //Limpar campos de Texto
            new Helpers().limparTela(painelProfessor);
            txtid_disciplina.setText(".");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione uma disciplina");
        }
    }//GEN-LAST:event_btnexcluirDisciplinaActionPerformed

    private void txtpesquisaDisciplinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisaDisciplinaKeyPressed
        //1 - receber o texto
        String nome = "%" + txtpesquisaDisciplina.getText() + "%";

        //1 - instanciar um objeto da classe ProfessorDAO
        DisciplinaDAO dao = new DisciplinaDAO();
        List<Disciplina> lista = dao.buscarDisciplinaPeloNome(nome);

        //2 - Criar o DefaultTableModel (conteúdo da tabela)
        DefaultTableModel conteudo = (DefaultTableModel) tabelaDisciplinas.getModel();
        conteudo.setNumRows(0);          
        
        //3 - Montar o conteúdo para exibir na tabela
        for (Disciplina disciplina : lista) {
            conteudo.addRow(new Object[]{
                disciplina.getId_disciplina(),
                disciplina.getNome(),
                disciplina.getCarga_horaria(),
                disciplina.getSemestre(),
                disciplina.getNomeProfessor()
            });
            }
    }//GEN-LAST:event_txtpesquisaDisciplinaKeyPressed

    private void btnpesquisaDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisaDisciplinaActionPerformed
         //1 - receber o texto
        String nome = "%" + txtpesquisaDisciplina.getText() + "%";

        //1 - instanciar um objeto da classe ProfessorDAO
        DisciplinaDAO dao = new DisciplinaDAO();
        List<Disciplina> lista = dao.buscarDisciplinaPeloNome(nome);

        //2 - Criar o DefaultTableModel (conteúdo da tabela)
        DefaultTableModel conteudo = (DefaultTableModel) tabelaDisciplinas.getModel();
        conteudo.setNumRows(0);          
        
        //3 - Montar o conteúdo para exibir na tabela
        for (Disciplina disciplina : lista) {
            conteudo.addRow(new Object[]{
                disciplina.getId_disciplina(),
                disciplina.getNome(),
                disciplina.getCarga_horaria(),
                disciplina.getSemestre(),
                disciplina.getNomeProfessor()
            });
            }
    }//GEN-LAST:event_btnpesquisaDisciplinaActionPerformed

    private void tabelaDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDisciplinasMouseClicked
        guias.setSelectedIndex(2);

        //Pegar os dados
        txtid_disciplina.setText(tabelaDisciplinas.getValueAt(tabelaDisciplinas.getSelectedRow(), 0).toString());
        txtnome_disciplina.setText(tabelaDisciplinas.getValueAt(tabelaDisciplinas.getSelectedRow(), 1).toString());
        txtcarga_horaria.setText(tabelaDisciplinas.getValueAt(tabelaDisciplinas.getSelectedRow(), 2).toString());
        txtsemestre.setText(tabelaDisciplinas.getValueAt(tabelaDisciplinas.getSelectedRow(), 3).toString());
        // Para selecionar o professor no CB vamos fazer uma busca, pois esse Combobox possui um objeto e não uma String
        String nomeProfessorNaTabela = tabelaDisciplinas.getValueAt(tabelaDisciplinas.getSelectedRow(), 4).toString();
        
        // Vamos percorrer item por item do ComboBox até achar o professor com o nome
        for (int i = 0; i < cbprofessor.getItemCount(); i++) {
            // Pegamos o objeto Professor que está nessa posição
            Professor profDoItem = (Professor) cbprofessor.getItemAt(i);
            
            // Verificamos: O nome desse professor é igual ao nome que estava na tabela?
            if (profDoItem.getNome().equals(nomeProfessorNaTabela)) {
                // Se for, selecionamos essa posição e paramos o loop (break)
                cbprofessor.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_tabelaDisciplinasMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnsalvar_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvar_alunoActionPerformed
        // Botão Salvar Aluno
        try {
            //1 - Receber os dados
            Aluno obj = new Aluno();

            obj.setNome(txtnome_aluno.getText());
            obj.setEmail(txtemail_aluno.getText());
            obj.setTelefoneCelular(txtcelular_aluno.getText());
            obj.setWhatsapp(txtwhatsapp_aluno.getText());
            obj.setEndereco(txtendereco_aluno.getText());
            obj.setCurso(txtcurso_aluno.getText());
            
            //data de nascimento
            // 1. Criamos um formatador para o padrão BR
            java.time.format.DateTimeFormatter formatoBr = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            // 2. Pegamos o texto (.getText()) e dizemos qual o formato dele
            obj.setData_nascimento(LocalDate.parse(txtdata_nascimento_aluno.getText(), formatoBr));

            //2 - Criar o objeto DAO pra salvar no banco
            AlunoDAO dao = new AlunoDAO();
            dao.cadastrarAluno(obj);

            //Limpar campos de Texto
            new Helpers().limparTela(painelAluno);
            txtid_aluno.setText(".");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro " + e);
        }
    }//GEN-LAST:event_btnsalvar_alunoActionPerformed

    private void btnalterar_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterar_alunoActionPerformed
        try {
            //1 - Receber os dados
            Aluno obj = new Aluno();

            obj.setNome(txtnome_aluno.getText());
            obj.setEmail(txtemail_aluno.getText());
            obj.setTelefoneCelular(txtcelular_aluno.getText());
            obj.setWhatsapp(txtwhatsapp_aluno.getText());
            obj.setEndereco(txtendereco_aluno.getText());
            obj.setCurso(txtcurso_aluno.getText());
            
            //data de nascimento
            // 1. Criamos um formatador para o padrão BR
            java.time.format.DateTimeFormatter formatoBr = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            // 2. Pegamos o texto (.getText()) e dizemos qual o formato dele
            obj.setData_nascimento(LocalDate.parse(txtdata_nascimento_aluno.getText(), formatoBr));
            
            obj.setId_aluno(Integer.parseInt(txtid_aluno.getText()));
            //2 - Criar o objeto DAO para salvar no banco

            AlunoDAO dao = new AlunoDAO();
            dao.alterarAluno(obj);

            AtualizarListas();

            //Limpar campos de Texto
            new Helpers().limparTela(painelAluno);
            txtid_aluno.setText(".");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Selecione um professor");
        }
    }//GEN-LAST:event_btnalterar_alunoActionPerformed

    private void btnexcluir_alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexcluir_alunoActionPerformed
        //Excluir
        try {
            int id = Integer.parseInt(txtid_aluno.getText());

            AlunoDAO dao = new AlunoDAO();
            dao.excluirAluno(id);

            AtualizarListas();

            //Limpar campos de Texto
            new Helpers().limparTela(painelAluno);
            txtid_aluno.setText(".");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione um aluno");
        }
    }//GEN-LAST:event_btnexcluir_alunoActionPerformed

    private void txtpesquisaAlunoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisaAlunoKeyPressed
        //1 - receber o texto
        String nome = "%" + txtpesquisaAluno.getText() + "%";

        //1 - instanciar um objeto da classe ProfessorDAO
        AlunoDAO dao = new AlunoDAO();
        List<Aluno> lista = dao.buscarAlunoPeloNome(nome);

        //2 - Criar o DefaultTableModel (conteúdo da tabela)
        DefaultTableModel conteudo = (DefaultTableModel) tabelaAlunos.getModel();
        conteudo.setNumRows(0);          
        
        //3 - Montar o conteúdo para exibir na tabela
        for (Aluno aluno : lista) {
            conteudo.addRow(new Object[]{
                aluno.getId_aluno(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getCurso(),
                aluno.getWhatsapp()
            });
            }
    }//GEN-LAST:event_txtpesquisaAlunoKeyPressed

    private void btnpesquisaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisaAlunoActionPerformed
        //1 - receber o texto
        String nome = "%" + txtpesquisaAluno.getText() + "%";

        //1 - instanciar um objeto da classe ProfessorDAO
        AlunoDAO dao = new AlunoDAO();
        List<Aluno> lista = dao.buscarAlunoPeloNome(nome);

        //2 - Criar o DefaultTableModel (conteúdo da tabela)
        DefaultTableModel conteudo = (DefaultTableModel) tabelaAlunos.getModel();
        conteudo.setNumRows(0);          
        
        //3 - Montar o conteúdo para exibir na tabela
        for (Aluno aluno : lista) {
            conteudo.addRow(new Object[]{
                aluno.getId_aluno(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getCurso(),
                aluno.getWhatsapp()
            });
            }
    }//GEN-LAST:event_btnpesquisaAlunoActionPerformed

    private void tabelaAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAlunosMouseClicked
        guias.setSelectedIndex(4);
        
        //Pegar os dados
        txtid_aluno.setText(tabelaAlunos.getValueAt(tabelaAlunos.getSelectedRow(), 0).toString());
        txtnome_aluno.setText(tabelaAlunos.getValueAt(tabelaAlunos.getSelectedRow(), 1).toString());
        txtemail_aluno.setText(tabelaAlunos.getValueAt(tabelaAlunos.getSelectedRow(), 2).toString());
        txtcurso_aluno.setText(tabelaAlunos.getValueAt(tabelaAlunos.getSelectedRow(), 3).toString());
        txtwhatsapp_aluno.setText(tabelaAlunos.getValueAt(tabelaAlunos.getSelectedRow(), 4).toString());
        
        int idSelecionado = Integer.parseInt(tabelaAlunos.getValueAt(tabelaAlunos.getSelectedRow(), 0).toString());
        
        for (Aluno listaDeAluno : listaDeAlunos) {
            if(listaDeAluno.getId_aluno() == idSelecionado){
                txtcelular_aluno.setText(listaDeAluno.getTelefoneCelular());
                txtendereco_aluno.setText(listaDeAluno.getEndereco());
                if (listaDeAluno.getData_nascimento() != null) {
                    java.time.format.DateTimeFormatter formatoBr = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String dataFormatada = listaDeAluno.getData_nascimento().format(formatoBr);
                    txtdata_nascimento_aluno.setText(dataFormatada);
                }
            }
        }
    }//GEN-LAST:event_tabelaAlunosMouseClicked

    private void btnlimparProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparProfessorActionPerformed
        //Limpar campos de Texto
            new Helpers().limparTela(painelProfessor);
            txtid_professor.setText(".");
    }//GEN-LAST:event_btnlimparProfessorActionPerformed

    private void btnlimparDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparDisciplinaActionPerformed
        //Limpar campos de Texto
            new Helpers().limparTela(painelDisciplina);
            txtid_disciplina.setText(".");
    }//GEN-LAST:event_btnlimparDisciplinaActionPerformed

    private void btnlimparAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparAlunoActionPerformed
        new Helpers().limparTela(painelAluno);
            txtid_aluno.setText(".");
    }//GEN-LAST:event_btnlimparAlunoActionPerformed

    private void txtpesquisaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesquisaAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpesquisaAlunoActionPerformed

    private void txtpesquisaDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesquisaDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpesquisaDisciplinaActionPerformed

    private void cbprofessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbprofessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbprofessorActionPerformed

    private void btnmatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmatriculaActionPerformed
        //desktopPaneControl.removeAll();
        IfrmMatricular ifrm1 = new IfrmMatricular();
        ifrm1.setVisible(true);
        desktopPaneControl.add(ifrm1);
    }//GEN-LAST:event_btnmatriculaActionPerformed

    private void btnGerenciarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenciarMatriculaActionPerformed
        //desktopPaneControl.removeAll();
        IfrmGerenciarMatricula ifrm2 = new IfrmGerenciarMatricula();
        ifrm2.setVisible(true);
        desktopPaneControl.add(ifrm2);
    }//GEN-LAST:event_btnGerenciarMatriculaActionPerformed

    private void btnnotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnotasActionPerformed
        IfrmNotas ifrm3 = new IfrmNotas();
        ifrm3.setVisible(true);
        desktopPaneControl.add(ifrm3);
    }//GEN-LAST:event_btnnotasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUnijorge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUnijorge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUnijorge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUnijorge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUnijorge().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerenciarMatricula;
    private javax.swing.JButton btnalterar;
    private javax.swing.JButton btnalterarDisciplina;
    private javax.swing.JButton btnalterar_aluno;
    private javax.swing.JButton btnexcluir;
    private javax.swing.JButton btnexcluirDisciplina;
    private javax.swing.JButton btnexcluir_aluno;
    private javax.swing.JButton btnlimparAluno;
    private javax.swing.JButton btnlimparDisciplina;
    private javax.swing.JButton btnlimparProfessor;
    private javax.swing.JButton btnmatricula;
    private javax.swing.JButton btnnotas;
    private javax.swing.JButton btnpesquisa;
    private javax.swing.JButton btnpesquisaAluno;
    private javax.swing.JButton btnpesquisaDisciplina;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JButton btnsalvarDisciplina;
    private javax.swing.JButton btnsalvar_aluno;
    private javax.swing.JComboBox<Object> cbprofessor;
    private javax.swing.JDesktopPane desktopPaneControl;
    private javax.swing.JTabbedPane guias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel painelAluno;
    private javax.swing.JPanel painelDisciplina;
    private javax.swing.JPanel painelProfessor;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JTable tabelaDisciplinas;
    private javax.swing.JTable tabelaProfessores;
    private javax.swing.JTextField txtcarga_horaria;
    private javax.swing.JFormattedTextField txtcelular_aluno;
    private javax.swing.JTextField txtcurso_aluno;
    private javax.swing.JFormattedTextField txtdata_nascimento_aluno;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtemail_aluno;
    private javax.swing.JTextField txtendereco;
    private javax.swing.JTextField txtendereco_aluno;
    private javax.swing.JTextField txtespecialidade;
    private javax.swing.JLabel txtid_aluno;
    private javax.swing.JLabel txtid_disciplina;
    private javax.swing.JLabel txtid_professor;
    private javax.swing.JTextField txtnome_aluno;
    private javax.swing.JTextField txtnome_disciplina;
    private javax.swing.JTextField txtnome_professor;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JTextField txtpesquisaAluno;
    private javax.swing.JTextField txtpesquisaDisciplina;
    private javax.swing.JTextField txtsemestre;
    private javax.swing.JFormattedTextField txttelefone;
    private javax.swing.JFormattedTextField txtwhatsapp;
    private javax.swing.JFormattedTextField txtwhatsapp_aluno;
    // End of variables declaration//GEN-END:variables

    private int parseInteger(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

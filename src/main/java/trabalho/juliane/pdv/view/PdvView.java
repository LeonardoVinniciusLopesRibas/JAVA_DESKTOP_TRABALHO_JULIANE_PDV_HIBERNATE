package trabalho.juliane.pdv.view;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import trabalho.juliane.pdv.dao.ItemVendaDao;
import trabalho.juliane.pdv.dao.ProdutoDao;
import trabalho.juliane.pdv.dao.VendaDao;
import trabalho.juliane.pdv.model.ItemVenda;
import trabalho.juliane.pdv.model.Produto;
import trabalho.juliane.pdv.model.Venda;
import trabalho.juliane.pdv.util.CustomRowHeight;
import trabalho.juliane.pdv.util.CustomTableModel;
import trabalho.juliane.pdv.util.EntityManagerUtil;
import trabalho.juliane.pdv.util.PosicaoFormulario;
import trabalho.juliane.pdv.util.SetIcon;
import trabalho.juliane.pdv.util.TabelaProdutos;

public class PdvView extends javax.swing.JFrame {

    SetIcon si = new SetIcon();
    PosicaoFormulario pf = new PosicaoFormulario();
    CustomRowHeight crh = new CustomRowHeight();
    private TabelaProdutos tabelaProdutos;
    private DefaultTableModel tableModel;
    int rowHeight = 40;

    public PdvView() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jbFinalizar.setEnabled(false);
        jbFinalizar.setEnabled(false);
        jbDescontoTotal.setEnabled(false);
        btRemoverDesconto.setEnabled(false);
        tableModel = new CustomTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Código Rápido");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Quantidade");
        tableModel.addColumn("Valor Unitário");
        tableModel.addColumn("Desconto");
        jtbProdutos.setModel(tableModel);
        si.setIconFinalizar(jbFinalizar);
        si.setDesconto(jbDescontoTotal);
        si.setAdicionarProduto(jbAddProduto);
        si.setAdicionarCliente(jbAddCliente);
        si.setNovaVenda(jbNovaVenda);
        si.setSair(jbSair);
        si.setRemoverDesconto(btRemoverDesconto);
        jtfValorTotalDesconto.setEditable(false);
        jtfValorTotalItens.setEditable(false);
        jtfValorTotalPagar.setEditable(false);
        jtfId.setEditable(false);
        jtfNomeCliente.setEditable(false);
        jtfCpfCnpj.setEditable(false);
        jtbProdutos.setDefaultRenderer(Object.class, new CustomRowHeight(rowHeight));
        jtbProdutos.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() == 3) {
                    calcularValorTotalCompra();
                    atualizarValorTotalPagar();
                }
                if (e.getColumn() == 5) {
                    calculaValorTotalDesconto();
                    atualizarValorTotalPagar();
                }
            }
        });
        calcularValorTotalCompra();
        calculaValorTotalDesconto();
        atualizarValorTotalPagar();
        jtbProdutos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int r = jtbProdutos.rowAtPoint(e.getPoint());
                if (r >= 0 && r < jtbProdutos.getRowCount()) {
                    jtbProdutos.setRowSelectionInterval(r, r);
                } else {
                    jtbProdutos.clearSelection();
                }
                int rowindex = jtbProdutos.getSelectedRow();
                if (rowindex < 0) {
                    return;
                }
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem removeItem = new JMenuItem("Remover Produto");
                    removeItem.addActionListener(e1 -> {
                        removerProdutoSelecionado();
                    });
                    popup.add(removeItem);
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            private void removerProdutoSelecionado() {
                int selectedRow = jtbProdutos.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) jtbProdutos.getModel();
                    model.removeRow(selectedRow);
                    calcularValorTotalCompra();
                    calculaValorTotalDesconto();
                    atualizarValorTotalPagar();
                    if (model.getRowCount() == 0) {
                        jbDescontoTotal.setEnabled(false);
                    }
                }
            }
        });
        jtbProdutos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int columnIndex = jtbProdutos.getSelectedColumn();
                if (columnIndex == 3 || columnIndex == 5) {
                    jtbProdutos.editCellAt(jtbProdutos.getSelectedRow(), columnIndex);
                    Component editor = jtbProdutos.getEditorComponent();
                    if (editor instanceof JTextField) {
                        JTextField textField = (JTextField) editor;
                        textField.selectAll();
                        textField.requestFocusInWindow();
                    }
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdFundo = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jtfValorTotalItens = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfCodigoRapido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfValorTotalDesconto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfValorTotalPagar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProdutos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jtfNomeCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfCpfCnpj = new javax.swing.JTextField();
        btRemover = new javax.swing.JButton();
        btRemoverDesconto = new javax.swing.JButton();
        jbFinalizar = new javax.swing.JButton();
        jbAddProduto = new javax.swing.JButton();
        jbNovaVenda = new javax.swing.JButton();
        jbAddCliente = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jbDescontoTotal = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 255));

        jPanel2.setBackground(new java.awt.Color(59, 93, 117));

        jtfValorTotalItens.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Valor Total dos Itens");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código Rápido");

        jtfCodigoRapido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtfCodigoRapido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoRapidoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Valor Total de Desc.");

        jtfValorTotalDesconto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Valor Total a Pagar");

        jtfValorTotalPagar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jtfValorTotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfValorTotalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfValorTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jtfCodigoRapido)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(96, 96, 96)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValorTotalItens, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValorTotalDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValorTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jtfCodigoRapido, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(313, Short.MAX_VALUE)))
        );

        jtbProdutos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "COD RAPIDO", "NOME", "QUANTIDADE", "VALOR", "DESCONTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbProdutos.setColumnSelectionAllowed(true);
        jtbProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbProdutos);
        jtbProdutos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nome");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cpf/Cnpj");

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btRemoverDesconto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRemoverDesconto.setMnemonic('D');
        btRemoverDesconto.setText("Remover Desconto");
        btRemoverDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverDescontoActionPerformed(evt);
            }
        });

        jbFinalizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbFinalizar.setText("Finalizar");
        jbFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarActionPerformed(evt);
            }
        });

        jbAddProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbAddProduto.setMnemonic('P');
        jbAddProduto.setText("Add Produto");
        jbAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddProdutoActionPerformed(evt);
            }
        });

        jbNovaVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbNovaVenda.setMnemonic('N');
        jbNovaVenda.setText("Nova Venda");
        jbNovaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovaVendaActionPerformed(evt);
            }
        });

        jbAddCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbAddCliente.setMnemonic('C');
        jbAddCliente.setText("Add Cliente");
        jbAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddClienteActionPerformed(evt);
            }
        });

        jbSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbSair.setMnemonic('S');
        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jbDescontoTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbDescontoTotal.setMnemonic('D');
        jbDescontoTotal.setText("Desconto");
        jbDescontoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDescontoTotalActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Id");

        jdFundo.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jtfNomeCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jtfCpfCnpj, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(btRemover, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(btRemoverDesconto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jbFinalizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jbAddProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jbNovaVenda, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jbAddCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jbSair, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jbDescontoTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdFundo.setLayer(jtfId, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdFundoLayout = new javax.swing.GroupLayout(jdFundo);
        jdFundo.setLayout(jdFundoLayout);
        jdFundoLayout.setHorizontalGroup(
            jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdFundoLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdFundoLayout.createSequentialGroup()
                        .addGroup(jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdFundoLayout.createSequentialGroup()
                                .addGroup(jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jdFundoLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel8))
                                    .addGroup(jdFundoLayout.createSequentialGroup()
                                        .addComponent(jtfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btRemover))))
                            .addGroup(jdFundoLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addGroup(jdFundoLayout.createSequentialGroup()
                        .addComponent(jbFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemoverDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDescontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAddProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jdFundoLayout.setVerticalGroup(
            jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdFundoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdFundoLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jdFundoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btRemover))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addGroup(jdFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbNovaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDescontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRemoverDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdFundo)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdFundo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarActionPerformed
        
        
        Venda venda = new Venda();
        int qtdProduto = tableModel.getRowCount();
        venda.setAtivo(true);
        venda.setQtdItens(qtdProduto);
        String valorTotal = jtfValorTotalPagar.getText();
        double valorTotalDouble = Double.parseDouble(valorTotal);
        venda.setValorTotal(valorTotalDouble);
        String valorTotalDesconto = jtfValorTotalDesconto.getText();
        double valorTotalDescontoDouble = Double.parseDouble(valorTotalDesconto);
        venda.setValorTotalDesconto(valorTotalDescontoDouble);

        EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
        VendaDao vd = new VendaDao(em);
        // Insira a venda no banco de dados e obtenha a instância gerenciada
        venda = vd.insertVenda(venda, em);

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setAtivo(true);
            itemVenda.setQuantidade(Integer.parseInt(tableModel.getValueAt(i, 3).toString()));

            String idProduto = tableModel.getValueAt(i, 0).toString();
            int idProdutoInt = Integer.parseInt(idProduto);
            ProdutoDao produtoDao = new ProdutoDao(em);
            Produto produto = produtoDao.selectByIdProduto(idProdutoInt);
            if (produto != null) {
                itemVenda.setProduto(produto);
            } else {
                System.out.println("Produto não encontrado para o ID: " + idProdutoInt);
            }

            // Associe a instância gerenciada de Venda ao itemVenda
            itemVenda.setVenda(venda);

            ItemVendaDao ivd = new ItemVendaDao(em);
            // Insira o item de venda no banco de dados
            ivd.insertItemVenda(itemVenda);
        }


    }//GEN-LAST:event_jbFinalizarActionPerformed

    private void jbDescontoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDescontoTotalActionPerformed
        double descontoTotal = Double.parseDouble(jtfValorTotalDesconto.getText());
        DescontoTotal dt = new DescontoTotal(this, descontoTotal);
        pf.abrirFormulario(dt, jdFundo);
    }//GEN-LAST:event_jbDescontoTotalActionPerformed

    private void jbAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddProdutoActionPerformed
        CarregaProdutosView cpv = new CarregaProdutosView(this);
        pf.abrirFormulario(cpv, jdFundo);
    }//GEN-LAST:event_jbAddProdutoActionPerformed

    private void jbAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddClienteActionPerformed
        CarregaClientesView ccv = new CarregaClientesView(this);
        pf.abrirFormulario(ccv, jdFundo);

    }//GEN-LAST:event_jbAddClienteActionPerformed

    private void jbNovaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovaVendaActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja iniciar nova venda?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            limpaCampos();
            jbDescontoTotal.setEnabled(false);
        }

    }//GEN-LAST:event_jbNovaVendaActionPerformed

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jbSairActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja remover o cliente da venda?", "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            jtfId.setText("");
            jtfNomeCliente.setText("");
            jtfCpfCnpj.setText("");
        }
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btRemoverDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverDescontoActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja remover o desconto de todos os produtos?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            removerDescontoProdutos();
        }
    }//GEN-LAST:event_btRemoverDescontoActionPerformed

    private void jtfCodigoRapidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoRapidoActionPerformed
        // TODO add your handling code here:
        String entrada = jtfCodigoRapido.getText().trim();
        String[] partes = entrada.split("\\*");
        int quantidade;
        String codigoRapido;

        if (partes.length == 2) {
            quantidade = Integer.parseInt(partes[0]);
            codigoRapido = partes[1];
        } else if (partes.length == 1) {
            quantidade = 1; // Se apenas o código rápido for informado, quantidade padrão é 1
            codigoRapido = partes[0];
        } else {
            JOptionPane.showMessageDialog(null, "Formato inválido. Use 'quantidade*codigorapido' ou 'codigorapido'.");
            jtfCodigoRapido.setText("");
            return;
        }

        Produto produto = consultarProdutoPorCodigoRapido(codigoRapido);
        if (produto != null) {
            adicionarProdutoTabela(produto, quantidade);
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
        }

        jtfCodigoRapido.setText("");
    }//GEN-LAST:event_jtfCodigoRapidoActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PdvView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EntityManagerUtil.getEntityManagerFactory();
                new PdvView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btRemoverDesconto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbAddCliente;
    public javax.swing.JButton jbAddProduto;
    public javax.swing.JButton jbDescontoTotal;
    public javax.swing.JButton jbFinalizar;
    public javax.swing.JButton jbNovaVenda;
    public javax.swing.JButton jbSair;
    private javax.swing.JDesktopPane jdFundo;
    public javax.swing.JTable jtbProdutos;
    public javax.swing.JTextField jtfCodigoRapido;
    public javax.swing.JTextField jtfCpfCnpj;
    public javax.swing.JTextField jtfId;
    public javax.swing.JTextField jtfNomeCliente;
    public javax.swing.JTextField jtfValorTotalDesconto;
    public javax.swing.JTextField jtfValorTotalItens;
    public javax.swing.JTextField jtfValorTotalPagar;
    // End of variables declaration//GEN-END:variables
    protected void limpaCampos() {
        jtfId.setText("");
        jtfCpfCnpj.setText("");
        jtfNomeCliente.setText("");
        jtfValorTotalDesconto.setText("");
        jtfValorTotalItens.setText("");
        jtfValorTotalPagar.setText("");
        DefaultTableModel model = (DefaultTableModel) jtbProdutos.getModel();
        model.setRowCount(0);
    }

    void enviaDados(int id, String nome, String cpfCnpj) {
        jtfId.setText(String.valueOf(id));
        jtfNomeCliente.setText(nome);
        jtfCpfCnpj.setText(cpfCnpj);
        jbAddProduto.setEnabled(true);

    }

    void enviaDadosProdutos(int id, String codigorapido, String descricao, int qtd, double valorvenda, double desconto) {
        Object[] dados = {id, codigorapido, descricao, qtd, valorvenda, desconto};
        tableModel.addRow(dados);
        calcularValorTotalCompra();
        calculaValorTotalDesconto();
        atualizarValorTotalPagar();
        jbDescontoTotal.setEnabled(true);
        btRemoverDesconto.setEnabled(true);
        jbFinalizar.setEnabled(true);
    }

    private void calcularValorTotalCompra() {
        double total = 0.0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int quantidade = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
            double valorUnitario = Double.parseDouble(tableModel.getValueAt(i, 4).toString());
            double subtotal = quantidade * valorUnitario;
            total += subtotal;
        }
        jtfValorTotalItens.setText(String.valueOf(total));
    }

    private void calculaValorTotalDesconto() {
        double totalDesc = 0.0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double desc = Double.parseDouble(tableModel.getValueAt(i, 5).toString());
            totalDesc += desc;
        }
        jtfValorTotalDesconto.setText(String.valueOf(totalDesc));
    }

    private void atualizarValorTotalPagar() {
        double valorItens = Double.parseDouble(jtfValorTotalItens.getText());
        double valorDesconto = Double.parseDouble(jtfValorTotalDesconto.getText());
        if (valorDesconto > valorItens) {
            JOptionPane.showMessageDialog(null, "Não é possível informar desconto maior que o valor total");
            int row = jtbProdutos.getSelectedRow();
            if (row != -1) {
                tableModel.setValueAt(0.0, row, 5);
            }
            valorDesconto = 0.0;
        }

        double valorPagar = valorItens - valorDesconto;
        jtfValorTotalPagar.setText(String.valueOf(valorPagar));
    }

    void calcularRateioDesconto(double descontoPorcentagem) {
        double totalItens = 0.0;
        double totalDesconto = 0.0;
        int rowCount = tableModel.getRowCount();
        double[] totalPorProduto = new double[rowCount];

        for (int i = 0; i < rowCount; i++) {
            int quantidade = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
            double valorUnitario = Double.parseDouble(tableModel.getValueAt(i, 4).toString());
            double valorTotalItem = quantidade * valorUnitario;
            totalPorProduto[i] = valorTotalItem;
            totalItens += valorTotalItem;
        }
        totalDesconto = totalItens * (descontoPorcentagem / 100.0);
        for (int i = 0; i < rowCount; i++) {
            double descontoProporcional = (totalPorProduto[i] / totalItens) * totalDesconto;
            tableModel.setValueAt(descontoProporcional, i, 5);
        }
        jtfValorTotalDesconto.setText(String.valueOf(totalDesconto));
        double novoValorPagar = totalItens - totalDesconto;
        jtfValorTotalPagar.setText(String.valueOf(novoValorPagar));
    }

    private void removerDescontoProdutos() {
        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            tableModel.setValueAt(0.0, i, 5);
        }
        jtfValorTotalDesconto.setText("0.0");
        atualizarValorTotalPagar();
    }

    private Produto consultarProdutoPorCodigoRapido(String codigoRapido) {
        EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        return produtoDao.selectByCodigoRapidoProduto(codigoRapido);
    }

    private void adicionarProdutoTabela(Produto produto, int quantidade) {
        Object[] dados = {produto.getId(), produto.getCodigoRapido(), produto.getDescricao(), quantidade, produto.getValorVenda(), 0.0};
        tableModel.addRow(dados);
        calcularValorTotalCompra();
        calculaValorTotalDesconto();
        atualizarValorTotalPagar();
        jbDescontoTotal.setEnabled(true);
    }

}

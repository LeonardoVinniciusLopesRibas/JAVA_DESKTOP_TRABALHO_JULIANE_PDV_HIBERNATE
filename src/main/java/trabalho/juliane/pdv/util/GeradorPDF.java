package trabalho.juliane.pdv.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

// Import classes from iText library
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.List;
import trabalho.juliane.pdv.model.ItemVenda;
import trabalho.juliane.pdv.model.Venda;

public class GeradorPDF {

    public void gerarPDF(Venda venda, List<ItemVenda> itensVenda) {
        try {
            // Create Document instance
            Document document = new Document();
            // Set up PDF writer to write to a file named "venda.pdf"
            PdfWriter.getInstance(document, new FileOutputStream("venda.pdf"));
            document.open();

            // Adiciona o cabeçalho "EMPRESA DA VIDA"
            document.add(new Paragraph("EMPRESA DA VIDA"));
            
            document.add(new Paragraph(" "));

            // Adiciona o nome do cliente
            //VALIDAR SE TEM CLIENTE AINDA
            if (venda.getCliente() != null) {
                document.add(new Paragraph("Cliente: " + venda.getCliente().getNome()));
            } else {
                document.add(new Paragraph("Não possui"));
            }

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            // Adiciona a tabela de produtos
            PdfPTable table = new PdfPTable(5); // 3 colunas para ID, Nome e Quantidade
            table.addCell("ID Produto");
            table.addCell("Nome Produto");
            table.addCell("Quantidade");
            //Quantidade * valor unitario
            table.addCell("Valor Unit");
            table.addCell("Valor Total");

            //itensVenda = venda.getItensVenda();
            if (itensVenda != null) {
                for (ItemVenda item : itensVenda) {
                    table.addCell(String.valueOf(item.getProduto().getId())); // ID do Produto
                    table.addCell(item.getProduto().getDescricao()); // Nome do Produto
                    table.addCell(String.valueOf(item.getQuantidade())); // Quantidade
                    table.addCell(String.valueOf(item.getProduto().getValorVenda())); // Valor Unitário do Produto
                    table.addCell(String.valueOf(item.getQuantidade() * item.getProduto().getValorVenda())); // Valor Total do Item
                }

            } else {
                // Handle the case where itensVenda is null
                // For example, you could log an error message or throw an exception
            }

            document.add(table); // Adiciona a tabela ao documento

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            // Adiciona os totais
            document.add(new Paragraph("Valor Total: " + venda.getValorTotal()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Valor Total com Desconto: " + venda.getValorTotalDesconto()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Valor Total a Pagar: " + (venda.getValorTotal() - venda.getValorTotalDesconto())));

            document.close(); // Close the document after writing

            // Open the PDF file using the default application
            File file = new File("venda.pdf");
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        }
    }

}

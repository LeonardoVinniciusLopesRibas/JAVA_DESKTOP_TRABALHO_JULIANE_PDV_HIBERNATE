package trabalho.juliane.pdv.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.List;
import trabalho.juliane.pdv.model.ItemVenda;
import trabalho.juliane.pdv.model.Venda;

public class GeradorPDF {

    public void gerarPDF(Venda venda, List<ItemVenda> itensVenda) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("venda.pdf"));
            document.open();
            Font fontNegrito = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Paragraph empresa = new Paragraph("MERCADINHO UNIPAR", fontNegrito);
            empresa.setAlignment(Element.ALIGN_CENTER);
            document.add(empresa);

            document.add(new Paragraph(" "));
            if (venda.getCliente() != null) {
                Paragraph cliente = new Paragraph("Cliente: " + venda.getCliente().getNome());
                cliente.setAlignment(Element.ALIGN_CENTER);
                document.add(cliente);
            } else {
                Paragraph clienteNot = new Paragraph("Cliente: Não possui");
                clienteNot.setAlignment(Element.ALIGN_CENTER);
                document.add(clienteNot);
            }

            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(5);
            table.addCell("ID Produto");
            table.addCell("Nome Produto");
            table.addCell("Quantidade");
            table.addCell("Valor Unit");
            table.addCell("Valor Total");

            if (itensVenda != null) {
                for (ItemVenda item : itensVenda) {
                    table.addCell(String.valueOf(item.getProduto().getId()));
                    table.addCell(item.getProduto().getDescricao());
                    table.addCell(String.valueOf(item.getQuantidade()));
                    table.addCell(String.valueOf(item.getProduto().getValorVenda()));
                    table.addCell(String.valueOf(item.getQuantidade() * item.getProduto().getValorVenda()));
                }

            }

            document.add(table);

            document.add(new Paragraph(" "));
            
            Paragraph valorTotal = new Paragraph("Valor Total: " + venda.getValorTotal());
            valorTotal.setAlignment(Element.ALIGN_CENTER);
            document.add(valorTotal);
            
            document.add(new Paragraph(" "));
            
            Paragraph valorTotalDesconto = new Paragraph("Valor de Desconto: " + venda.getValorTotalDesconto());
            valorTotalDesconto.setAlignment(Element.ALIGN_CENTER);
            document.add(valorTotalDesconto);
            
            document.add(new Paragraph(" "));
            
            Paragraph valorTotalPagar = new Paragraph("Valor Total a Pagar: " + (venda.getValorTotal() - venda.getValorTotalDesconto()));
            valorTotalPagar.setAlignment(Element.ALIGN_CENTER);
            document.add(valorTotalPagar);

            document.close();

            File file = new File("venda.pdf");
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
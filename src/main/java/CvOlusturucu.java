import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CvOlusturucu {

    public static void main(String[] args) {

        try {
            // 1. KİŞİSEL BİLGİLER VE İŞ DENEYİMLERİ NESNELERİNİ OLUŞTURMA
            KisiselBilgiler kisi = new KisiselBilgiler(
                    "Ahmet",
                    "Cengizler",
                    "ahmet.cengizler@email.com",
                    "+90 555 123 45 67",
                    "Bursa, Türkiye"
            );

            List<IsDeneyimi> deneyimler = new ArrayList<>();
            deneyimler.add(new IsDeneyimi(
                    "ABC Teknoloji",
                    "Yazılım Stajyeri",
                    "Haziran 2024",
                    "Eylül 2024",
                    "- Java ve Spring Boot kullanarak web servisleri geliştirme süreçlerinde görev alındı."
            ));
            deneyimler.add(new IsDeneyimi(
                    "DEF Tech",
                    "Junior Java Geliştirici",
                    "Ekim 2024",
                    "Mart 2025",
                    "- Mevcut projelerin test ve geliştirme süreçlerinde görev alındı.\n- Veritabanı ve sistem optimize edildi."
            ));
            deneyimler.add(new IsDeneyimi(
                    "GHI Digital",
                    "Web Geliştirici",
                    "Nisan 2025",
                    "Halen",
                    "- Yeni web servis entegrasyonu ve testlerinde görev alındı.\n- Kod tabanında performans analizi ve raporlama."
            ));

            // 2. PDF OLUŞTURMA SÜRECİ
            String dosyaYolu = "ozgecmis.pdf";
            PdfWriter writer = new PdfWriter(dosyaYolu);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // TÜRKÇE KARAKTER DESTEĞİ İÇİN FONT TANIMLAMASI
            String fontYolu = "C:/Windows/Fonts/arial.ttf";
            PdfFont font = PdfFontFactory.createFont(fontYolu, PdfEncodings.IDENTITY_H, true);
            document.setFont(font);

            // Fotoğraf Ekleme
            Image foto = new Image(ImageDataFactory.create("profil.jpg"));
            foto.setWidth(100);
            foto.setHeight(100);
            document.add(foto);

            document.add(new Paragraph(kisi.ad + " " + kisi.soyad)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(24));

            document.add(new Paragraph(kisi.email + " | " + kisi.telefon + " | " + kisi.adres)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(10));

            document.add(new Paragraph("\n--------------------------------------------------\n"));

            // --- İş Deneyimi Bölümü ---
            document.add(new Paragraph("Deneyimler")
                    .setBold()
                    .setFontSize(18));

            for (IsDeneyimi deneyim : deneyimler) {
                Text pozisyonText = new Text(deneyim.pozisyon).setBold();
                Text sirketText = new Text(" - " + deneyim.sirketAdi);
                document.add(new Paragraph().add(pozisyonText).add(sirketText));

                document.add(new Paragraph(deneyim.baslangicTarihi + " - " + deneyim.bitisTarihi)
                        .setFontSize(9)
                        .setItalic());

                document.add(new Paragraph(deneyim.aciklama)
                        .setFontSize(10));

                document.add(new Paragraph("\n"));
            }

            document.close();

            System.out.println("ozgecmis.pdf dosyası başarıyla oluşturuldu!");

        } catch (IOException e) {
            System.err.println("Hata: Font dosyası okunamadı veya dosya oluşturulamadı! " + e.getMessage());
            e.printStackTrace();
        }
    }
}
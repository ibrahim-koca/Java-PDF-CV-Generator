# Java PDF CV Generator

Bu proje, Java dilini kullanarak dinamik olarak PDF formatında bir özgeçmiş (CV) oluşturan bir komut satırı uygulamasıdır. Nesneye Yönelimli Programlama dersi ödevi kapsamında geliştirilmiştir. Proje, PDF manipülasyonu için popüler iTextPDF kütüphanesini kullanmaktadır.

## ✨ Özellikler

* Kişisel bilgileri ve iş deneyimlerini nesne yönelimli bir yaklaşımla modüler sınıflarda (`KisiselBilgiler`, `IsDeneyimi`) yönetir.
* Verilen bilgilerle dinamik olarak bir PDF dosyası oluşturur.
* Oluşturulan PDF'e bir profil fotoğrafı ekler.
* Türkçe karakter desteği için özel font yapılandırması içerir.
* Proje bağımlılıkları Maven ile yönetilmektedir.

## 🛠️ Kullanılan Teknolojiler

* **Dil:** Java
* **Bağımlılık Yönetimi:** Maven
* **Kütüphane:** iTextPDF 7 (PDF oluşturma ve düzenleme için)

## 🚀 Kurulum ve Çalıştırma

Projeyi yerel makinenizde çalıştırmak için aşağıdaki adımları izleyebilirsiniz.

**Gereksinimler:**
* Java Development Kit (JDK) 11 veya üstü
* Apache Maven

**Adımlar:**

1.  **Projeyi klonlayın:**
    ```bash
    git clone [https://github.com/ibrahim-koca/Java-PDF-CV-Generator.git](https://github.com/ibrahim-koca/Java-PDF-CV-Generator.git)
    ```

2.  **Proje dizinine gidin:**
    ```bash
    cd Java-PDF-CV-Generator
    ```

3.  **Gerekli dosyaları hazırlayın:**
    * Projenin ana dizinine `profil.jpg` adında bir resim dosyası ekleyin.
    * **Not:** `CvOlusturucu.java` içerisindeki font yolu (`C:/Windows/Fonts/arial.ttf`) Windows sistemlerine göre ayarlanmıştır. Farklı bir işletim sistemi kullanıyorsanız bu yolu sisteminizde geçerli bir `.ttf` fontu ile değiştirmeniz gerekebilir.

4.  **Projeyi Maven ile derleyin ve çalıştırın:**
    ```bash
    # Projeyi derler ve bağımlılıkları indirir
    mvn clean install

    # Projeyi çalıştırır
    mvn exec:java -Dexec.mainClass="CvOlusturucu"
    ```

## 📄 Proje Çıktısı

Proje başarıyla çalıştığında, ana dizinde `ozgecmis.pdf` adında aşağıdaki gibi bir dosya oluşturulur.

*(Buraya oluşturulan PDF'in bir ekran görüntüsünü ekleyebilirsin. Örneğin, `output-screenshot.png` adında bir ekran görüntüsü alıp projeye ekledikten sonra aşağıdaki satırı kullanabilirsin.)*

`![Proje Çıktısı](output-screenshot.png)`

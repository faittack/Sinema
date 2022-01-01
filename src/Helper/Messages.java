package Helper;

import javax.swing.*;

public class Messages {

    public static void showMesaj(String str) {
        String msj;

        switch (str) {
            case "hata":
                msj = "Yanlış bir değer girdiniz.";
                break;
            case "fill":
                msj = "Lütfen tüm alanları doldurunuz.";
                break;
            case "wrong":
                msj="Hatalı giriş.";
                break;
            case"match":
                msj="Başka bir kullanıcı adı seçiniz.";
                break;
            case "succes":
                msj="İşlem Başarılı";
                break;
            case "have":
                msj="Film zaten eklenmiş.";
                break;
            case "any":
                msj="Kullanıcı bulunamadı.";
                break;
            case "not found":
                msj="Aradığınız bulunamadı.";
                break;
            default:
                msj = str;
        }
        JOptionPane.showMessageDialog(null, msj, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
    }

   /* public static boolean confirm(String str){
        String msj;
            switch (str){
                case"sure":
                    msj="Bu işlemi yapmak istiyor musun?";
                    break;
                default:
                    msj=str;
                    break;
            }

            int duru=JOptionPane.showConfirmDialog(null,msj,"Dikkat!",JOptionPane.YES_NO_OPTION);
            if (duru==0)
                return true;
            else
                return false;

    }*/
}

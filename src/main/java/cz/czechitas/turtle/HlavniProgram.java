package cz.czechitas.turtle;

import cz.czechitas.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {

    public void main(String[] args) {
        Turtle zofka;

        zofka = new Turtle();

        Color cervena;
        cervena = new Color(150, 10, 10);

        Color modra;
        modra = new Color(20, 10, 100);

        Color svetleModra;
        svetleModra = new Color(118, 118, 233);

        Color zluta;
        zluta = new Color(220, 191, 18);

        nakresliMasinu(zofka, cervena, zluta, modra, 300, 100);
        nakresliZmrzlinu(zofka, cervena, zluta, 200, 200);
        nakresliSnehulaka(zofka, svetleModra, 400, 200);


    }

    private void nakresliMasinu(Turtle zofka, Color modra, Color cervena, Color zluta, double newX, double newY) {
        zofka.setLocation(newX, newY);
        nakresliObdelnik(zofka, 30, 60, modra);
        zofka.setLocation(newX + 60, newY);
        nakresliObdelnik(zofka, 60, 40, modra);
        nakresliKolecko(zofka, 20, cervena);
        zofka.setLocation(newX + 30, newY + 15);
        nakresliKolecko(zofka, 10, cervena);
        zofka.setLocation(newX + 5, newY + 15);
        nakresliKolecko(zofka, 10, cervena);
        zofka.setLocation(newX, newY - 20);
        zofka.turnLeft(135);
        nakresliTrojuhelnik(zofka, 20, 90, zluta);
    }

    private void nakresliZmrzlinu(Turtle zofka, Color cervena, Color zluta, double newX, double newY) {
        zofka.setLocation(newX, newY);
        nakresliKolecko(zofka, 50, zluta);
        zofka.setLocation(newX + 95, newY + 18);
        zofka.turnLeft(90);
        nakresliTrojuhelnik(zofka, 200, 26, cervena);
    }

    private void nakresliSnehulaka(Turtle zofka, Color svetleModra, double newX, double newY) {
        zofka.setLocation(newX, newY);
        nakresliKolecko(zofka, 20, svetleModra); //hlava
        zofka.setLocation(newX - 20, newY + 60);
        nakresliKolecko(zofka, 40, svetleModra); //bricho
        zofka.setLocation(newX - 40, newY + 160);
        nakresliKolecko(zofka, 60, svetleModra); //spodek
        zofka.setLocation(newX - 40, newY + 60);
        nakresliKolecko(zofka, 10, svetleModra); //ruka
        zofka.setLocation(newX + 60, newY + 60);
        nakresliKolecko(zofka, 10, svetleModra); //ruka
    }

    private void nakresliCtverec(Turtle zofka, double stranaCtverce, Color barvaCtverce) {
        for (int i = 0; i < 4; i++) {
            zofka.setPenColor(barvaCtverce);
            zofka.move(stranaCtverce);
            zofka.turnRight(90);
        }
    }

    private void nakresliObdelnik(Turtle zofka, double stranaA, double stranaB, Color barvaObdelniku) {
        for (int i = 0; i < 2; i++) {
            zofka.setPenColor(barvaObdelniku);
            zofka.move(stranaA);
            zofka.turnRight(90);
            zofka.move(stranaB);
            zofka.turnRight(90);
        }
    }

    private void nakresliKolecko(Turtle zofka, double polomer, Color barvaKolecka) {
        double uhel = polomer * 2; //aby to bylo kolečko
        double delkaStrany = polomer * 2 * Math.PI / uhel;
        for (int i = 0; i < uhel; i++) {
            zofka.setPenColor(barvaKolecka);
            zofka.move(delkaStrany);
            zofka.turnRight(360 / uhel);
        }

    }

    private void nakresliTrojuhelnik(Turtle zofka, double delkaRamene, double uhelMeziRameny, Color barvaTrojuhelniku) {
        zofka.setPenColor(barvaTrojuhelniku);
        zofka.move(delkaRamene * Math.sin((uhelMeziRameny * Math.PI / 180) / 2) * 2);
        zofka.turnLeft((180 - (180 - uhelMeziRameny) / 2));
        zofka.move(delkaRamene);
        zofka.turnLeft(180 - uhelMeziRameny);
        zofka.move(delkaRamene);


    }
}

insert into KORISNIK(username, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga, aktivan) values ('Aca', '123', 'Aleksandar', 'Aleksic', '06312345', 'aca@mail.com', '1999-05-01', 'ADMIN', true)
insert into KORISNIK(username, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga, aktivan) values ('Jovo', '321', 'Jovan', 'Jovanovic', '063543221', 'jovo@mail.com', '1997-05-01', 'MENADZER', true)
insert into KORISNIK(username, lozinka, ime, prezime, telefon, email, datumrodjenja, uloga, aktivan) values ('Miki', '555', 'Milos', 'Milosic', '0635555', 'miki@mail.com', '1996-05-01', 'GLEDAOC', true)

insert into BIOSKOP(naziv, adresa, brcentrale, email, menadzer_id) values ('Arena Cineplex', 'Bulevar Mihajla Pupina', '021555333', 'arena@mail.com', 2)
insert into BIOSKOP(naziv, adresa, brcentrale, email, menadzer_id) values ('Cinestar', 'Sentandrejski put', '021333555', 'big@mail.com', 2)

insert into FILM(naziv, opis, zanr, ocena, trajanje) values ('Lepa sela lepo gore', 'Vojska u tunelu', 'Ratni', 8.64, 120)
insert into FILM(naziv, opis, zanr, ocena, trajanje) values ('Kad porastem bicu kengur', 'Kengur je golman', 'Komedija', 9.64, 110)
insert into FILM(naziv, opis, zanr, ocena, trajanje) values ('Rane', 'Kriminal', 'Triler komedija', 8.76, 109)

insert into SALA(kapacitet, oznakasale) values (200, '11')
insert into SALA(kapacitet, oznakasale) values (100, '21')
insert into SALA(kapacitet, oznakasale) values (50, '31')

insert into BIOSKOP_SALA(sala_id, bioskop_id) values (1, 2)
insert into BIOSKOP_SALA(sala_id, bioskop_id) values (3, 2)
insert into BIOSKOP_SALA(sala_id, bioskop_id) values (2, 1)

insert into KORISNIK_FILM(ocena, korisnik_id, film_id) values (8.5, 3, 1)
insert into KORISNIK_FILM(ocena, korisnik_id, film_id) values (7.5, 3, 2)
insert into KORISNIK_FILM(ocena, korisnik_id, film_id) values (9.25, 3, 3)

insert into PROJEKCIJA(vremeprojekcije, cena, sala_id, film_id) values ('2020-05-08 16:30', 350, 1, 2)
insert into PROJEKCIJA(vremeprojekcije, cena, sala_id, film_id) values ('2020-05-09 19:00', 450, 2, 1)
insert into PROJEKCIJA(vremeprojekcije, cena, sala_id, film_id) values ('2020-05-10 21:45', 550, 3, 3)

insert into REZERVACIJE (datumrezervacije, korisnik_id, film_id) values ('2020-05-07 15:32', 3, 1)
insert into REZERVACIJE (datumrezervacije, korisnik_id, film_id) values ('2020-05-08 16:30', 3, 2)
insert into REZERVACIJE (datumrezervacije, korisnik_id, film_id) values ('2020-05-10 21:45', 3, 3)















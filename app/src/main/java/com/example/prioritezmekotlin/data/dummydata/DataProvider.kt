package com.example.prioritezmekotlin.data.dummydata

import com.example.prioritezmekotlin.data.db.Priority
import com.example.prioritezmekotlin.data.db.Task

object DataProvider {

    private val titles = listOf(
        "Dokończ Raport",
        "Przygotuj Prezentację",
        "Zadzwoń do Klienta",
        "Aktualizuj Zawartość Strony",
        "Weź Udział w Spotkaniu Zespołu",
        "Przejrzyj Kod",
        "Wysyłka Faktur",
        "Badanie Trendów na Rynku",
        "Plan Kampanii Marketingowej",
        "Organizuj Pliki",
        "Przygotuj Propozycję Budżetu",
        "Twórz Mockupy Produktu",
        "Planuj Posty na Mediach Społecznościowych",
        "Spotkanie z Zespołem Projektowym",
        "Testuj Nowe Oprogramowanie",
        "Dochodź do Potencjalnych Klientów",
        "Projektuj Logo",
        "Napisz Post na Blogu",
        "Ustal Harmonogram Projektu",
        "Przejrzyj Specyfikacje Produktu",
        "Organizuj Plan Podróży",
        "Przeprowadź Ankietę Użytkowników",
        "Analizuj Dane Sprzedażowe",
        "Przygotuj Materiały Szkoleniowe",
        "Koordynuj Logistykę Wydarzenia",
        "Burza Mózgów nad Nowymi Pomysłami",
        "Optymalizuj SEO Strony",
        "Przeprowadź Oceny Wyników Pracowników",
        "Twórz Prototypy Aplikacji"
    )

    private val descriptions = listOf(
        "Ukończ końcowy raport dotyczący wyników kwartalnych.",
        "Stwórz prezentację PowerPoint na nadchodzące spotkanie z klientem.",
        "Skontaktuj się z klientem w celu dalszej rozmowy.",
        "Aktualizuj treść na stronie głównej witryny internetowej.",
        "Zorganizuj logistykę nadchodzącego wydarzenia firmowego.",
        "Burz mózg nad innowacyjnymi pomysłami na poprawę produktu.",
        "Optymalizuj SEO strony internetowej dla lepszych wyników w wyszukiwarkach.",
        "Przeprowadź oceny wyników pracowników zespołu.",
        "Twórz interaktywne prototypy dla nowej aplikacji.",
        "Dokładnie przetestuj i oceniaj funkcjonalność nowego oprogramowania. Dokumentuj wszelkie błędy lub problemy i współpracuj blisko z zespołem developerskim, aby zapewnić ich szybkie rozwiązanie.",
        "Kontynuuj kontakt z potencjalnymi klientami i odpowiedz na zapytania wygenerowane przez kampanie marketingowe i wydarzenia networkingowe. Udziel spersonalizowanych odpowiedzi i dostarcz informacji dostosowanych do potrzeb każdego potencjalnego klienta.",
        "Zaprojektuj nowe logo dla przemiany marki, biorąc pod uwagę tożsamość marki, grupę docelową i trendy w branży. Przedstaw wiele opcji logo w celu uzyskania opinii i wybierz ostateczny projekt.",
        "Napisz dobrze przemyślany i informacyjny post na blogu na temat najnowszych wydarzeń w branży. Wykorzystaj dane, statystyki i wiedzę ekspertów, aby dostarczyć cenne treści czytelnikom bloga.",
        "Ustal harmonogram dla nadchodzących faz projektu, uwzględniając dostępność zasobów, zależności i potencjalne ryzyka. Podziel się harmonogramem z interesariuszami projektu w celu uzyskania opinii.",
        "Przejrzyj i sfinalizuj specyfikacje produktu, upewniając się, że są one kompleksowe i zgodne z celami projektu. Podziel się specyfikacjami z zespołem developerskim w celu wdrożenia.",
        "Zaplanuj plan podróży służbowej, uwzględniając rozkłady lotów, zakwaterowanie, transport i organizację spotkań. Podziel się planem podróży ze wszystkimi odpowiednimi członkami zespołu.",
        "Przeprowadź szczegółową ankietę, aby pozyskać opinię użytkowników na temat użyteczności produktu, funkcji i ogólnego zadowolenia. Analizuj wyniki ankiety, aby zidentyfikować obszary do poprawy.",
        "Analizuj dane sprzedażowe i identyfikuj trendy w celu podejmowania decyzji opartych na danych dotyczących strategii sprzedaży i poprawek produktowych. Przygotuj obszerny raport, aby przedstawić wyniki zespołowi sprzedażowemu i zarządowi.",
        "Przygotuj materiały szkoleniowe dla nowych pracowników, w tym przewodniki wprowadzające, moduły szkoleniowe i prezentacje. Upewnij się, że materiały obejmują wszystkie istotne aspekty roli nowego pracownika.",
        "Koordynuj logistykę nadchodzącego wydarzenia firmowego, takiego jak konferencja czy wyjazd integracyjny zespołu. Zabezpiecz lokalizacje, catering, transport i wszelkie niezbędne wyposażenie.",
        "Burz mózg nad innowacyjnymi pomysłami na poprawę produktu, uwzględniając opinię użytkowników, trendy rynkowe i postęp technologiczny. Przedstaw pomysły zespołowi rozwoju produktu w celu oceny.",
        "Optymalizuj SEO strony internetowej, aby poprawić pozycje w wynikach wyszukiwania i zwiększyć ruch organiczny. Przeprowadź badania słów kluczowych, aktualizuj meta tagi i wdroż na stronie najlepsze praktyki SEO.",
        "Przeprowadź oceny wyników pracowników, dostarczając konstruktywną opinię i wyznaczając cele rozwoju osobistego i zawodowego. Doceniaj i nagradzaj wyjątkowe osiągnięcia.",
        "Twórz interaktywne prototypy dla nowej aplikacji, uwzględniając przyjazny dla użytkownika design i intuicyjną nawigację. Testuj prototypy z potencjalnymi użytkownikami, aby uzyskać opinię i walidację."
    )

    val tasks = (0..1).map { Task(
        title = titles.random(),
        description = descriptions.random(),
        priority = Priority.values().random()
    ) }
}
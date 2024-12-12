Dokumentation im README.md: Erstellen Sie eine aussagekräftige README.md-Datei, in der
Sie Ihr Projekt, die Projektstruktur und die Nutzung Ihres Programms beschreiben.

### Aufbau
 - **Bag:** Item, das vom InventorySystem sortiert, gefiltert, etc wird
 - **InventorySystem:** Verwaltet das Inventar (`bags`), sortiert und filtert die Items (`Bag`)
 - **InventoryGUI:** Das grafische Nutzerinterface des Ganzen. Separat von `InventorySystem`, um die Klassen übersichtlicher und modular zu gestalten.


### GUI Design
Man gibt die Werte ein und kann durch diese die Objekte entweder filtern oder ein neues Objekt erstellen.
Der `Hinzufügen` Button ist erst dann auswählbar, wenn in jedem Feld (außer vegan) ein Wert drin steht.
Um ein neues Objekt hinzufügen zu können, müssen alle Werte gültig sein (gewicht und preis müssen in ein double konvertierbar sein). 
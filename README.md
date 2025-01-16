## GUI Design und Funktionsweise des Programmes
In der GUI kann man Taschen selbst erstellen und diese Taschen dann nach Preis oder Gewicht auf- oder absteigend sortieren. Außerdem können die Taschen nach Gesamtpreis zusammenaddiert sowie auf ein bestimmtes Attribut (isVegan, Farbe, Gewicht, Preis) gefiltert werden.
Das Projekt verwendet den Model-View-Controller Pattern, bei dem die Klasse 'Bag' das Modell ist, InventoryGUI.form der View und InventoryGUI.java, sowie seine Hilfsklasse, InventorySystem sind Controller.
## Aufbau
### Bag:
Item, das vom InventorySystem verwaltet wird. 

[![](https://mermaid.ink/img/pako:eNplkcFuwyAMhl_F8inRuhfIsdvukzZ10sTFBY-gJTgC0mqq-u4jgVZadkHw_T-_bbigFsPYoR4oxmdHNtCovHGBdXLiYf-u_KrBnixclAd4BCPzcWCYgtNcyFsKzlvQMkj44zmzs30q6CgyMHlw8cCW_AIfIHJ6XXKacqGFkzhTJHuT2pp2xx9r6obHO_8flbW1ZlN72GhPS99NGWLTQZHaOmHBScppg-tcmdYqyl9VXnCHI4eRnMkPvT6hwtTzyAq7vDUUvhVmb_bRnLN_vMYuhZl3GGS2PXZfNMR8midDiesv3SwT-U-RcWN6MS5JqPD6Cw8dpjE?type=png)](https://mermaid.live/edit#pako:eNplkcFuwyAMhl_F8inRuhfIsdvukzZ10sTFBY-gJTgC0mqq-u4jgVZadkHw_T-_bbigFsPYoR4oxmdHNtCovHGBdXLiYf-u_KrBnixclAd4BCPzcWCYgtNcyFsKzlvQMkj44zmzs30q6CgyMHlw8cCW_AIfIHJ6XXKacqGFkzhTJHuT2pp2xx9r6obHO_8flbW1ZlN72GhPS99NGWLTQZHaOmHBScppg-tcmdYqyl9VXnCHI4eRnMkPvT6hwtTzyAq7vDUUvhVmb_bRnLN_vMYuhZl3GGS2PXZfNMR8midDiesv3SwT-U-RcWN6MS5JqPD6Cw8dpjE)
### InventorySystem:
Die `InventorySystem` Klasse beherbergt die ArrayListe der `Bag` Objekte. 
Sie kümmert sich primär um die Verwaltung des Inventars. 
In der Klasse sind die Methoden enthalten, mit denen man die Taschen nach ihren Attributen filtern kann. 
Außerdem beinhaltet sie Methoden, mit denen man die Taschen nach Preis und Gewicht sortieren kann, sowie eine Methode, welche die Summe der Preise der Taschen berechnet.

[![](https://mermaid.ink/img/pako:eNqVUstqwzAQ_BWhk03dH_CtbnooFFpwaaF1D2trI6vRI6zlgAnJt1exnELcJNCDQd4Zzcxqd8sbJ5DnvNHQdQsFksBUVijCxitnWfFa2RFjj3aD1jsayqHzaNi2sozdsjsiGJ5U5_cFyD2rQXZnAR1OKIoJvmEN6KbsTZIy4fpaY6wqq_xz_Y0rjwHZOCVifam0R3pHJVufLMYL6cwhEkEcPJLSk7Iym7QzVjunEeyx8Ff6hVSDV5Ul-kP65DwaVd5Qgk2KaHaeSGjcBg8Zw5ceg0XMkUAqhqnN09u_PVzzv3fa0dT8xS5K1GG4cRYXuvEuaozYLEjKIvb5dRI6PuC_MnezLHOfOKNdFV6HZ9wgGVAi7Oq4eRX3LRqseB6OAmhV8cANPOhD-sE2PPfUY8bJ9bLl-RJ0F_76tQCP06IfKWuwH86ZGelBqLDuU3H3A19SHgI?type=png)](https://mermaid.live/edit#pako:eNqVUstqwzAQ_BWhk03dH_CtbnooFFpwaaF1D2trI6vRI6zlgAnJt1exnELcJNCDQd4Zzcxqd8sbJ5DnvNHQdQsFksBUVijCxitnWfFa2RFjj3aD1jsayqHzaNi2sozdsjsiGJ5U5_cFyD2rQXZnAR1OKIoJvmEN6KbsTZIy4fpaY6wqq_xz_Y0rjwHZOCVifam0R3pHJVufLMYL6cwhEkEcPJLSk7Iym7QzVjunEeyx8Ff6hVSDV5Ul-kP65DwaVd5Qgk2KaHaeSGjcBg8Zw5ceg0XMkUAqhqnN09u_PVzzv3fa0dT8xS5K1GG4cRYXuvEuaozYLEjKIvb5dRI6PuC_MnezLHOfOKNdFV6HZ9wgGVAi7Oq4eRX3LRqseB6OAmhV8cANPOhD-sE2PPfUY8bJ9bLl-RJ0F_76tQCP06IfKWuwH86ZGelBqLDuU3H3A19SHgI)
### InventoryGUI:
Die Klasse `InventoryGIU` beinhaltet eine Implementierung der `InventorySystem` Klasse und „füttert“ diese Implementierung mit Werten, 
die sie aus den Eingabefeldern der zugehörigen Formdatei ausliest und in sinnvolle Datentypen umwandelt. 
Des Weiteren beinhaltet sie die Listener, die die jeweiligen Methoden aufruft, welche dann die benötigten Eingaben 
auswerten und mithilfe der `InventorySystem` Instanz dann die entsprechenden Operationen durchführt. 
Besonders wichtig ist die `updateList()` Methode, welche jedes Mal aufgerufen werden muss, 
wenn sich etwas bei der Darstellung der Listenelemente ändern sollte. 

[![hi](https://mermaid.ink/img/pako:eNqFU01v2zAM_SuCTi3Q_YHcmu4DGXYo5nYFBl8UibWJSqIhU1mNovntk2WliJKuu1gUH_XeIy29SE0G5Epqq8bxM6ouKNd6gwE0I3mxvmt9xsTG78Azhenb_Ua8tF6IT-L7D7UFK_4Adj3nuOTv4Jm_Ilgj-BA95KJ_47cBNTTRlYp1ZE76OoBiWDYFaXQga2-VBzG-hZWfYaY6tnNDbktreha6BD9R9xx9t-BvrTXTyOAE-t1_fNYml_4rkwV5RMsQ8pEKni1b4aa8nntPY_jQ_g1ZCrXScKZRWcgnKniR03P-WKs69Qs65d8jPbisGXHkfcMBfbcXmAY5Jw4t9KCfcgslyNTvaT6cDbMD3vghcu7h4lIsEjWWR5wwQ3Fry-9BjzxbAA9hTNiO0CyIMmatuiqViK5HnVJbIgvqRHoxdcIfB5Pu5qxwcR2CmnL_iXd_wpsZcr_H9K9t-sgr6SA4hSa9wfyoWsk9OGjlKoVGhadWptpUpyJTM3ktVxwiXMlAsevl6lHZMe0WL-UBH0oG5X8TuZOiLwbTXS_J17-fJWYg?type=png)](https://mermaid.live/edit#pako:eNqFU01v2zAM_SuCTi3Q_YHcmu4DGXYo5nYFBl8UibWJSqIhU1mNovntk2WliJKuu1gUH_XeIy29SE0G5Epqq8bxM6ouKNd6gwE0I3mxvmt9xsTG78Azhenb_Ua8tF6IT-L7D7UFK_4Adj3nuOTv4Jm_Ilgj-BA95KJ_47cBNTTRlYp1ZE76OoBiWDYFaXQga2-VBzG-hZWfYaY6tnNDbktreha6BD9R9xx9t-BvrTXTyOAE-t1_fNYml_4rkwV5RMsQ8pEKni1b4aa8nntPY_jQ_g1ZCrXScKZRWcgnKniR03P-WKs69Qs65d8jPbisGXHkfcMBfbcXmAY5Jw4t9KCfcgslyNTvaT6cDbMD3vghcu7h4lIsEjWWR5wwQ3Fry-9BjzxbAA9hTNiO0CyIMmatuiqViK5HnVJbIgvqRHoxdcIfB5Pu5qxwcR2CmnL_iXd_wpsZcr_H9K9t-sgr6SA4hSa9wfyoWsk9OGjlKoVGhadWptpUpyJTM3ktVxwiXMlAsevl6lHZMe0WL-UBH0oG5X8TuZOiLwbTXS_J17-fJWYg)

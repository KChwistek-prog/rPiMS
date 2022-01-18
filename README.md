# rPiMS
# raspberryPi Monitoring System - driver
Część projektu na raspberryPi pomagająca monitorować i kontrolować temperatury fermentacji na fermzilli. Driver - serwer odpalany na rPi odpowiada za sterowanie modułami - sensorami oraz układem chłodzenia.

Endpointy:<br>
/temperature - udostępnia odczyt czujnika wewnątrz fermentora (thermowell)<br>
/setTemp/{temp} - ustawia temperaturę dla pompy z układu chłodzenia<br>
/startCooling - odpala pompę układu chłodzenia<br>
/stopCooling - wyłącza pompę układu chłodzenia

TODO:<br>
-aktualizacja pi4j-core do 2.1.1<br>
-rozbudowa o czujnik temperatury pomieszczenia<br>
-zbudować i podpiąć układ chłodzenia (obecnie placeholder w postaci diody)



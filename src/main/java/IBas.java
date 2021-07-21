public interface IBas {
    void leftOnTheRoute(); // автобус выехал на маршрут
    void pulledUpToBusStop(String busStop); // автобус подъехал к остановке (мгновенно)
    void disembarkationEmbarkationOfPassengers(); //высадка/посадка пассажиров занимает 3с
    void leftTheBus(String busStop); // автобус отъехал от остановки (мгновенно)
    void returnedToTheDepot(); // автобус вернулся в депо
}

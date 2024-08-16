package Semenar_2DZ;

import java.util.List;

public interface MarketBehaviour {
    void acceptToMarket(MainInterface actor);

    void releaseFromMarket(List<MainInterface> actors);

    void update();
}

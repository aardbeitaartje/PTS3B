package data.interfaces;

import models.Bid;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IBidContext {

    ArrayList<Bid> getBids(final int auctionId) throws SQLException, IOException, ClassNotFoundException;
    Bid getMostRecentBidForAuctionWithId(final int auctionId) throws SQLException, IOException, ClassNotFoundException;
}

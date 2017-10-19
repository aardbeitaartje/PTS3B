package data.interfaces;

import models.Auction;
import utilities.enums.AuctionLoadingType;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IAuctionContext {

    ArrayList<Auction> getAuctionsForSearchTerm(final String searchTerm) throws SQLException, IOException, ClassNotFoundException;
    ArrayList<Auction> getAuctionsForProfile(final int profileId) throws SQLException, IOException, ClassNotFoundException;
    Auction getAuctionForId(final int auctionId, final AuctionLoadingType auctionLoadingType) throws SQLException, IOException, ClassNotFoundException;
    boolean addAuction(final Auction auction) throws SQLException;
    boolean addBid(final double amount, final int accountId, final int auctionId);
    boolean manuallyEndAuction(final int auctionId);
    boolean auctionIsClosed(final int auctionId) throws SQLException;
}

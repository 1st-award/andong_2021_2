interface WithdrawUI {
    public void promptForWithdrawalAmount();
    public void informInsufficientFunds();
}

interface DepositUI {
    public void promptForDepositAmount();
    public void promptForEnvelope();
}

interface TransferUI {
    public void promptForTransferAmount();
    public void promptForFromAccount();
    public void promptForToAccount();
}

interface Screen {
    default void displayMessage() {}
}

class MessageLog {
    public void logMessage() {}
}

public class UI implements WithdrawUI, DepositUI, TransferUI{
    private Screen itScreen;
    private MessageLog itMessageLog;
    public void displayMessage() {
        itScreen.displayMessage();
        itMessageLog.logMessage();
    }

    @Override
    public void promptForTransferAmount() {

    }

    @Override
    public void promptForFromAccount() {

    }

    @Override
    public void promptForToAccount() {

    }

    @Override
    public void promptForWithdrawalAmount() {

    }

    @Override
    public void informInsufficientFunds() {

    }

    @Override
    public void promptForDepositAmount() {

    }

    @Override
    public void promptForEnvelope() {

    }
}

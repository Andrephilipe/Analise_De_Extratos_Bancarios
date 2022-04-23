package com.desenvolvimento.drs;

import java.util.List;

public interface BankStatementParser {

    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);

}

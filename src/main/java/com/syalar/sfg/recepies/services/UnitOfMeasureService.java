package com.syalar.sfg.recepies.services;

import com.syalar.sfg.recepies.commands.UnitOfMeasureCommand;

import java.util.List;

public interface UnitOfMeasureService {
    List<UnitOfMeasureCommand> listAllUoms();
}

package com.rog.teach.simpleSpring.entity;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommandManager {
    protected abstract Object createCommand();
}

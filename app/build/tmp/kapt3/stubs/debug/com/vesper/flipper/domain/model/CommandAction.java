package com.vesper.flipper.domain.model;

import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

@kotlinx.serialization.Serializable
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0087\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0012"}, d2 = {"Lcom/vesper/flipper/domain/model/CommandAction;", "", "(Ljava/lang/String;I)V", "LIST_DIRECTORY", "READ_FILE", "WRITE_FILE", "CREATE_DIRECTORY", "DELETE", "MOVE", "RENAME", "COPY", "GET_DEVICE_INFO", "GET_STORAGE_INFO", "SEARCH_FAPHUB", "INSTALL_FAPHUB_APP", "PUSH_ARTIFACT", "EXECUTE_CLI", "Companion", "app_debug"})
public enum CommandAction {
    @kotlinx.serialization.SerialName(value = "list_directory")
    /*public static final*/ LIST_DIRECTORY /* = new LIST_DIRECTORY() */,
    @kotlinx.serialization.SerialName(value = "read_file")
    /*public static final*/ READ_FILE /* = new READ_FILE() */,
    @kotlinx.serialization.SerialName(value = "write_file")
    /*public static final*/ WRITE_FILE /* = new WRITE_FILE() */,
    @kotlinx.serialization.SerialName(value = "create_directory")
    /*public static final*/ CREATE_DIRECTORY /* = new CREATE_DIRECTORY() */,
    @kotlinx.serialization.SerialName(value = "delete")
    /*public static final*/ DELETE /* = new DELETE() */,
    @kotlinx.serialization.SerialName(value = "move")
    /*public static final*/ MOVE /* = new MOVE() */,
    @kotlinx.serialization.SerialName(value = "rename")
    /*public static final*/ RENAME /* = new RENAME() */,
    @kotlinx.serialization.SerialName(value = "copy")
    /*public static final*/ COPY /* = new COPY() */,
    @kotlinx.serialization.SerialName(value = "get_device_info")
    /*public static final*/ GET_DEVICE_INFO /* = new GET_DEVICE_INFO() */,
    @kotlinx.serialization.SerialName(value = "get_storage_info")
    /*public static final*/ GET_STORAGE_INFO /* = new GET_STORAGE_INFO() */,
    @kotlinx.serialization.SerialName(value = "search_faphub")
    /*public static final*/ SEARCH_FAPHUB /* = new SEARCH_FAPHUB() */,
    @kotlinx.serialization.SerialName(value = "install_faphub_app")
    /*public static final*/ INSTALL_FAPHUB_APP /* = new INSTALL_FAPHUB_APP() */,
    @kotlinx.serialization.SerialName(value = "push_artifact")
    /*public static final*/ PUSH_ARTIFACT /* = new PUSH_ARTIFACT() */,
    @kotlinx.serialization.SerialName(value = "execute_cli")
    /*public static final*/ EXECUTE_CLI /* = new EXECUTE_CLI() */;
    @org.jetbrains.annotations.NotNull
    public static final com.vesper.flipper.domain.model.CommandAction.Companion Companion = null;
    
    CommandAction() {
    }
    
    @org.jetbrains.annotations.NotNull
    public static kotlin.enums.EnumEntries<com.vesper.flipper.domain.model.CommandAction> getEntries() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0001\u00a8\u0006\u0006"}, d2 = {"Lcom/vesper/flipper/domain/model/CommandAction$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vesper/flipper/domain/model/CommandAction;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.serialization.KSerializer<com.vesper.flipper.domain.model.CommandAction> serializer() {
            return null;
        }
    }
}
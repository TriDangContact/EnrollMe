package repository;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import models.Major;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class MajorRepository {
    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public MajorRepository(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext) {
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public CompletionStage<Map<String, String>> options() {
        return supplyAsync(Major.find::all, executionContext)
                .thenApply(list -> {
                    HashMap<String, String> options = new LinkedHashMap<>();
                    for (Major major : list) {
                        options.put(Integer.toString(major.getId()), major.getName());
                    }

                    return options;
                });
    }
}

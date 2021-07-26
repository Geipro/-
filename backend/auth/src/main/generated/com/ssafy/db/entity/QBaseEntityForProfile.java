package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;

/**
 * QBaseEntity is a Querydsl query type for BaseEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QBaseEntityForProfile extends EntityPathBase<BaseEntityForProfile> {

    private static final long serialVersionUID = 1717725014L;

    public static final QBaseEntityForProfile baseEntity = new QBaseEntityForProfile("baseEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QBaseEntityForProfile(String variable) {
        super(BaseEntityForProfile.class, forVariable(variable));
    }

    public QBaseEntityForProfile(Path<? extends BaseEntityForProfile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseEntityForProfile(PathMetadata metadata) {
        super(BaseEntityForProfile.class, metadata);
    }

}

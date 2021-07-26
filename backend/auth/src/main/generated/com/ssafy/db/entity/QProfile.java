package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

@Generated("com.querydsl.codegen.EntitySerializer")
public class QProfile extends EntityPathBase<Profile>{
    private static final long serialVersionUID = 72737374L;

    public static final QProfile profile = new QProfile("profile");

    public final QBaseEntityForProfile _super = new QBaseEntityForProfile(this);
    
    public final StringPath profileId = createString("profileId");

    public final StringPath userId = createString("userId");
    
    public final StringPath nickname = createString("nickname");
    
    public final StringPath phoneNum = createString("phoneNum");
    
    public final StringPath aboutMe = createString("aboutMe");
    
    public final StringPath profileImg = createString("profileImg");
    
    public final StringPath backImg = createString("backImg");
    
    public final NumberPath<Integer> totalPoint = createNumber("totalPoint", Integer.class);
    
    public QProfile(String variable) {
        super(Profile.class, forVariable(variable));
    }

    public QProfile(Path<? extends Profile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProfile(PathMetadata metadata) {
        super(Profile.class, metadata);
    }
}

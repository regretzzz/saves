package population.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2017-07-27 09:20:54")
/** */
public final class PersonModelMeta extends org.slim3.datastore.ModelMeta<population.model.PersonModel> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<population.model.PersonModel> address = new org.slim3.datastore.StringAttributeMeta<population.model.PersonModel>(this, "address", "address");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<population.model.PersonModel, java.lang.Long> age = new org.slim3.datastore.CoreAttributeMeta<population.model.PersonModel, java.lang.Long>(this, "age", "age", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<population.model.PersonModel> firstName = new org.slim3.datastore.StringAttributeMeta<population.model.PersonModel>(this, "firstName", "firstName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<population.model.PersonModel, java.lang.Long> id = new org.slim3.datastore.CoreAttributeMeta<population.model.PersonModel, java.lang.Long>(this, "id", "id", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<population.model.PersonModel, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<population.model.PersonModel, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<population.model.PersonModel> lastName = new org.slim3.datastore.StringAttributeMeta<population.model.PersonModel>(this, "lastName", "lastName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<population.model.PersonModel, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<population.model.PersonModel, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final PersonModelMeta slim3_singleton = new PersonModelMeta();

    /**
     * @return the singleton
     */
    public static PersonModelMeta get() {
       return slim3_singleton;
    }

    /** */
    public PersonModelMeta() {
        super("PersonModel", population.model.PersonModel.class);
    }

    @Override
    public population.model.PersonModel entityToModel(com.google.appengine.api.datastore.Entity entity) {
        population.model.PersonModel model = new population.model.PersonModel();
        model.setAddress((java.lang.String) entity.getProperty("address"));
        model.setAge((java.lang.Long) entity.getProperty("age"));
        model.setFirstName((java.lang.String) entity.getProperty("firstName"));
        model.setId((java.lang.Long) entity.getProperty("id"));
        model.setKey(entity.getKey());
        model.setLastName((java.lang.String) entity.getProperty("lastName"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        population.model.PersonModel m = (population.model.PersonModel) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("address", m.getAddress());
        entity.setProperty("age", m.getAge());
        entity.setProperty("firstName", m.getFirstName());
        entity.setProperty("id", m.getId());
        entity.setProperty("lastName", m.getLastName());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        population.model.PersonModel m = (population.model.PersonModel) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        population.model.PersonModel m = (population.model.PersonModel) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        population.model.PersonModel m = (population.model.PersonModel) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        population.model.PersonModel m = (population.model.PersonModel) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        population.model.PersonModel m = (population.model.PersonModel) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAddress() != null){
            writer.setNextPropertyName("address");
            encoder0.encode(writer, m.getAddress());
        }
        if(m.getAge() != null){
            writer.setNextPropertyName("age");
            encoder0.encode(writer, m.getAge());
        }
        if(m.getFirstName() != null){
            writer.setNextPropertyName("firstName");
            encoder0.encode(writer, m.getFirstName());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLastName() != null){
            writer.setNextPropertyName("lastName");
            encoder0.encode(writer, m.getLastName());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected population.model.PersonModel jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        population.model.PersonModel m = new population.model.PersonModel();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("address");
        m.setAddress(decoder0.decode(reader, m.getAddress()));
        reader = rootReader.newObjectReader("age");
        m.setAge(decoder0.decode(reader, m.getAge()));
        reader = rootReader.newObjectReader("firstName");
        m.setFirstName(decoder0.decode(reader, m.getFirstName()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lastName");
        m.setLastName(decoder0.decode(reader, m.getLastName()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}
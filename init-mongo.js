const appUser = process.env.DB_USERNAME || 'default_user';
const appPassword = process.env.DB_PASSWORD || 'default_password';

db = db.getSiblingDB("tachyon");

db.createCollection("users");

db.createUser({
    user: appUser,
    pwd: appPassword,
    roles: [{ role: "readWrite", db: "tachyon" }],
});

print(`User ${appUser} successfully created in the database tachyon.`);

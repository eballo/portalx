db.createUser(
        {
            user: "portalx",
            pwd: "portalx",
            roles: [
                {
                    role: "readWrite",
                    db: "portalx"
                }
            ]
        }
);

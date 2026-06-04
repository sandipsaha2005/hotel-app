import { createClient } from "redis";


export const redisServer = async () => {
    const host =  Deno.env.get("REDIS_HOST")
    const client = createClient({
        socket: {
            host: host || "localhost",
            port: Number(Deno.env.get("REDIS_PORT")) || 6379,
        },
    });
    console.log({host});
    await client.connect();

    return client;
};
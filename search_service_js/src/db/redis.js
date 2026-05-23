import { createClient } from "redis";

const client = createClient({
  socket: {
    host: Deno.env.get("REDIS_HOST") || "localhost",
    port: Number(Deno.env.get("REDIS_PORT")) || 6379,
  },
});

await client.connect();

export const getCache = async (key) => {
  const cached = await client.get(key);

  if (!cached) return null;

  return JSON.parse(cached);
};

export const setCache = async (key, value, ttlSeconds = 60) => {
  await client.set(key, JSON.stringify(value), {
    ex: ttlSeconds,
  });
};

export const deleteCache = async (key) => {
  await client.del(key);
};

import tweepy
import mysql.connector
from mysql.connector import Error
import config
import connection

client = tweepy.Client(bearer_token=config.BAERER_TOKEN)

query = "flamengo -is:retweet -is:reply"


response = client.search_recent_tweets(query=query, max_results=10, tweet_fields=[
                                       'created_at', 'lang'], user_fields=['profile_image_url'], expansions=['author_id'])

users = {u['id']: u for u in response.includes['users']}

for tweet in response.data:
    if users[tweet.author_id]:
        user = users[tweet.author_id]
        connection.salvarUsuario(user.username, user.profile_image_url)
        connection.salvarPerfil(user.username)
        connection.salvarTweet(user.username, tweet.text,
                               user.profile_image_url)

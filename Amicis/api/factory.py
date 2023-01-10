import tweepy
import pandas as pd
import mysql.connector
from mysql.connector import Error

# Configure suas credenciais de autenticação
consumer_key = 'qxQ0PieTERsq4WOcZZpHYTbLk'
consumer_secret = 'xtGc0X97umTfU2BXF4M3yOPN2K07NikMpxNzrwXGnCMfP08prI'
access_token = '959910840110583808-T1zELjVXHn2olFYoCmN5MDkJzSmEW8W'
access_token_secret = 'Ts5e5i54rKimrT71JARy7u75Wr3zjcbZNrUgou1bu60xp'

# Autentique-se na API
auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)
api = tweepy.API(auth)

# Cria um cursor para buscar tweets
cursor = tweepy.Cursor(api.search, q='pelé', tweet_mode='extended')

# Itera sobre os tweets
for tweet in cursor.items(10):
    print(tweet.user.name + ": " + tweet.full_text)


con = mysql.connector.connect(
    host='localhost', database='Amicis', user='root', password='Banco123')

sql = "INSERT INTO usuario (this_usuario, nome) VALUES (%s, %s)"
val = ("mariax2", "maria")

try:
    cursor = con.cursor()

    cursor.execute(sql, val)

    con.commit()
except Error as e:
    print("Erro ao acessar tabela MySQL", e)
finally:
    if (con.is_connected()):
        con.close()
        cursor.close()
        print("Conexão ao MySQL encerrada")

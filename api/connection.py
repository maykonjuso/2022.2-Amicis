import mysql.connector
from mysql.connector import Error


def salvarUsuario(nome, foto):

    con = mysql.connector.connect(
        host='localhost', database='Amicis', user='root', password='Banco123')

    sql = "INSERT INTO usuario (this_usuario, foto, senha) VALUES (%s, %s, %s)"
    val = (nome, foto, 1234)

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


def salvarPerfil(nome):

    con1 = mysql.connector.connect(
        host='localhost', database='Amicis', user='root', password='Banco123')

    sql1 = "INSERT INTO perfil(usuario, localidade) VALUES ((SELECT this_usuario FROM usuario WHERE this_usuario = %s), %s);"
    val1 = (nome, "API")

    try:
        cursor1 = con1.cursor()

        cursor1.execute(sql1, val1)

        con1.commit()
    except Error as e:
        print("Erro ao acessar tabela MySQL", e)
    finally:
        if (con1.is_connected()):
            con1.close()
            cursor1.close()
            print("Conexão ao MySQL encerrada")


def salvarTweet(nome, tweet, foto):

    con2 = mysql.connector.connect(
        host='localhost', database='Amicis', user='root', password='Banco123')

    sql2 = "INSERT INTO publicacao(usuario, texto, foto) VALUES ((SELECT usuario FROM perfil WHERE usuario = %s), %s, %s);"
    val2 = (nome, tweet, foto)

    try:
        cursor2 = con2.cursor()

        cursor2.execute(sql2, val2)

        con2.commit()
    except Error as e:
        print("Erro ao acessar tabela MySQL", e)
    finally:
        if (con2.is_connected()):
            con2.close()
            cursor2.close()
            print("Conexão ao MySQL encerrada")

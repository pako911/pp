from sqlalchemy import create_engine, Column, String, Integer, MetaData, Table, ARRAY
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker, relationships

Base = declarative_base()
metadata = MetaData()


class Person(Base):
    __tablename__ = "persons"

    id = Column('id', Integer, primary_key=True)
    first_name = Column('first name', String, nullable=False)
    last_name = Column('last name', String, nullable=False)

    street = Column('street', String, unique=False)
    city = Column('city', String, unique=False)
    zip_code = Column('ZIP code', String(6), unique=False)
    phone = Column('phone', String, unique=True)
    email = Column('e-mail', String, unique=True)

    '''address = Table('address', metadata,
                    Column('street', String, unique=False),
                    Column('city', String, unique=False),
                    Column('ZIP code', String, unique=False),
                    Column('phone', String, unique=False),
                    Column('e-mail', String, unique=False))'''

    '''persons = Table('persons', metadata,
                    Column('id', Integer, primary_key=True),
                    Column('first name', String, nullable=False),
                    Column('last name', String, nullable=False))'''


def add_person():
    Session = sessionmaker(bind=engine)
    session = Session()
    person = Person()
    user_input = int(input("Podaj id:"))
    person.id = user_input
    user_input = input("Podaj imie:")
    person.first_name = user_input
    user_input = input("Podaj nazwisko:")
    person.last_name = user_input
    user_input = input("Podaj nazwe miasta:")
    person.city = user_input
    user_input = input("Podaj nazwe ulicy:")
    person.street = user_input
    user_input = input("Podaj kod pocztowy:")
    person.zip_code = user_input

    phone_numbers = int(input("Ile numerow telefonow chcesz podac?:"))
    list_of_numbers = []
    for i in range(phone_numbers):
        user_input = input("Podaj numer telefonu:")
        list_of_numbers.append(user_input)

    person.phone = ', '.join(list_of_numbers)

    email_numbers = int(input("Ile adresow e-mail chcesz podac?:"))
    list_of_emails = []
    for i in range(email_numbers):
        user_input = input("Podaj adres e-mail:")
        list_of_emails.append(user_input)

    person.email = ', '.join(list_of_emails)

    session.add(person)
    session.commit()

    session.close()


def find_person():
    Session = sessionmaker(bind=engine)
    session = Session()

    persons = session.query(Person).all()
    user_input = input("Podaj nazwisko osoby ktora chcesz wyswietlic:")
    i = 0
    for person in persons:
        if person.last_name == user_input:
            i += 1
            print("Id: %d, Imie: %s, Nazwisko: %s " % (person.id, person.first_name,
                                                       person.last_name))

    if i == 0:
        print("Nie ma osoby o nazwisku", user_input)

    session.close()


engine = create_engine("sqlite:///users.db")
Base.metadata.create_all(bind=engine)


def main():
    add_person()
    find_person()


main()

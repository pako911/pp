import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns
from sklearn.datasets import load_boston


def zadanie1():
    bd = load_boston()
    # print(bd.keys())

    df = pd.DataFrame(bd.data, columns=bd.feature_names)
    df['MEDV'] = pd.Series(bd.target)

    return df


def zadanie2(data_frame):
    data_frame.info()


def zadanie3(data_frame):
    print(data_frame.describe())


def zadanie4(data_frame):
    sns.distplot(data_frame['MEDV'].tolist())
    plt.grid()
    plt.show()


def zadanie5(data_frame):
    mat = data_frame.corr()
    sns.heatmap(mat)
    plt.show()
    plt.close()
    sns.regplot(data_frame['MEDV'].tolist(), data_frame['RM'].tolist())\
        .set_title('dodatnio skorelowane')
    plt.show()
    plt.close()
    sns.regplot(data_frame['MEDV'].tolist(), data_frame['LSTAT'].tolist())\
        .set_title('ujemnie skorelowane')
    plt.show()
    plt.close()
    sns.regplot(data_frame['MEDV'].tolist(), data_frame['CHAS'].tolist())\
        .set_title('najmniej skorelowane')
    plt.show()


def main():
    print('zadanie 1:\n')
    data_frame = zadanie1()
    print('Dziesięć pierwszych: \n', data_frame.head(10))
    print('Dziesięć ostatnich: \n', data_frame.tail(10))

    print('\nzadanie 2:')
    zadanie2(data_frame)

    print('\nzadanie 3:')
    zadanie3(data_frame)

    # zadanie4(data_frame)
    zadanie5(data_frame)


if __name__ == "__main__":
        main()

def ask_question(question):
    answer = input(question + " (yes/no): ").lower()
    while answer not in ['yes', 'no']:
        print("Invalid input. Please answer with 'yes' or 'no'.")
        answer = input(question + " (yes/no): ").lower()
    return answer == 'yes'


def main():
    print("Welcome to the Hospital Expert System!")
    print("Please answer the following questions to find the suitable medical facility.")

    has_fever = ask_question("Do you have a fever?")
    has_cough = ask_question("Do you have a cough?")
    has_breathing_difficulty = ask_question("Do you have difficulty breathing?")
    has_chest_pain = ask_question("Do you have chest pain?")
    has_headache = ask_question("Do you have a headache?")

    # Diagnosis
    if has_fever and has_cough and has_breathing_difficulty:
        print("You may have symptoms of respiratory infection. Please visit the Emergency Room.")
    elif has_chest_pain and has_breathing_difficulty:
        print("You may be experiencing a heart-related issue. Please visit the Cardiology Department.")
    elif has_headache:
        print("You may be experiencing a migraine. Please visit the Neurology Department.")
    else:
        print("Based on the provided information, we recommend you to visit the General Medicine Department.")

    print("Thank you for using the Hospital Expert System!")


if __name__ == '__main__':
    main()
